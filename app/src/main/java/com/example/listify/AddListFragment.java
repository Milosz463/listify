package com.example.listify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

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




        adapter=new ArrayAdapter<>(getContext(),R.layout.list_view_style,arrayListProducts);
        listViewNewLists.setAdapter(adapter);

        buttonGoBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_addListFragment_to_homeFragment);
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
        buttonConfirmList.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         test();

                         Bundle result =new Bundle();
                         result.putBoolean("ListAdded",true);

                         getParentFragmentManager().setFragmentResult(
                                 "ListAddedResult",
                                 result
                         );
                        Navigation.findNavController(v).navigate(R.id.action_addListFragment_to_homeFragment);
                    }
                }
        );

        return view;
    }
    public void test(){
        ListName listName=new ListName();
        listName.setListName(editTextListName.getText().toString());
    }
}