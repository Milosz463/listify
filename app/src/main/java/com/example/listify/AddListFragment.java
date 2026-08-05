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
import android.widget.ListView;

public class AddListFragment extends Fragment {
    ArrayAdapter<String>adapter;
    public AddListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_list,container,false);
        ListView listViewNewLists=view.findViewById(R.id.listView);
        Button buttonGoBack=view.findViewById(R.id.buttonGoBack);
        String[]elementy={""};
        adapter=new ArrayAdapter<>(getContext(),R.layout.list_view_style,elementy);
        listViewNewLists.setAdapter(adapter);

        buttonGoBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_addListFragment_to_homeFragment);
                    }
                }
        );
        return view;
    }
}