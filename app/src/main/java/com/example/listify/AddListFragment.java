package com.example.listify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddListFragment extends Fragment {

    ArrayList<String>arrayListProducts=new ArrayList<>();
    ArrayAdapter<String>adapter;
    EditText editTextListName;
    ListsViewModel listsViewModel;
    public AddListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_list,container,false);

        ListView listViewNewLists=view.findViewById(R.id.listViewProducts);
        Button buttonGoBack=view.findViewById(R.id.buttonGoBack);
        Button buttonAddProduct=view.findViewById(R.id.buttonAddProduct);
        Button buttonConfirmList=view.findViewById(R.id.buttonConfirmList);
        EditText editTextProductName=view.findViewById(R.id.editTextTextProductName);
        editTextListName=view.findViewById(R.id.editTextListName);
        listsViewModel = new ViewModelProvider(requireActivity())
                .get(ListsViewModel.class);




        adapter=new ArrayAdapter<>(getContext(),R.layout.list_view_style,arrayListProducts);
        listViewNewLists.setAdapter(adapter);

        buttonGoBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_addListFragment_to_homeFragment);
                        buttonGoBack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (listsViewModel.getNamesOfLists().isEmpty()) {
                                    Bundle result = new Bundle();
                                    result.putBoolean("ListAdded", true);

                                    getParentFragmentManager().setFragmentResult(
                                            "ListAddedResult",
                                            result
                                    );
                                }

                                Navigation.findNavController(v).navigate(
                                        R.id.action_addListFragment_to_homeFragment
                                );
                            }
                        });
                    }
                }
        );

        buttonAddProduct.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        arrayListProducts.add(editTextProductName.getText().toString());
                        adapter.notifyDataSetChanged();
                        editTextProductName.setText("");

                    }
                }
        );

        buttonConfirmList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextListName.getText().toString();

                if (!name.isEmpty()) {
                    listsViewModel.addList(name);
                }

                Navigation.findNavController(v).navigate(
                        R.id.action_addListFragment_to_homeFragment
                );
            }
        });


        return view;
    }
}