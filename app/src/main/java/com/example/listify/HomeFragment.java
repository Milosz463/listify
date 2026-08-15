package com.example.listify;

import static android.view.View.GONE;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.listify.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    ImageView backgroundImageImageView;
    TextView hintTextView;

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
        addListButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addListFragment);
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
        hideView();

        return view;
    }
    public void hideView(){
        getParentFragmentManager().setFragmentResultListener(
                "ListAddedResult",
                this,
                ((requestKey, result) ->
                {
                    boolean listAdded=result.getBoolean("ListAdded");

                    if(listAdded){
                        backgroundImageImageView.setVisibility(GONE);
                        hintTextView.setVisibility(GONE);
                    }
                })
        );
    }

}