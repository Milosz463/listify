package com.example.listify;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.listify.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    ImageView backgroundImageImageView;
    TextView hintTextView;
    ListView listViewOfShoppingList;
    ArrayAdapter <String>arrayAdapter;
    ListsViewModel listsViewModel;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        Button addListButton=view.findViewById(R.id.buttonAddList);
        backgroundImageImageView=view.findViewById(R.id.imageViewBackgroundLogo);
        hintTextView=view.findViewById(R.id.textViewHint);
        SearchView searchListSearchView=view.findViewById(R.id.searchView);
        listViewOfShoppingList=view.findViewById(R.id.ListViewOfShoppingLists);

        listsViewModel = new ViewModelProvider(requireActivity())
                .get(ListsViewModel.class);

        arrayAdapter=new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,listsViewModel.getNamesOfLists());
        listViewOfShoppingList.setAdapter(arrayAdapter);

        addListButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goToAddNewList(view);
                    }
                });

        searchListSearchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextChange(String s) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }
                }
        );

        listViewOfShoppingList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        goIntoList(view);
                    }
                }
        );
        hideView();

        return view;
    }

    public void hideView() {

        if (listsViewModel.getNamesOfLists().isEmpty()) {

            backgroundImageImageView.setVisibility(VISIBLE);
            hintTextView.setVisibility(VISIBLE);
            listViewOfShoppingList.setVisibility(GONE);

        } else {

            backgroundImageImageView.setVisibility(GONE);
            hintTextView.setVisibility(GONE);
            listViewOfShoppingList.setVisibility(VISIBLE);
        }
    }

    public void goToAddNewList(View view){
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addListFragment);
    }
    public void goIntoList(View view){
Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_fragmentListItems);
    }
//todo
}