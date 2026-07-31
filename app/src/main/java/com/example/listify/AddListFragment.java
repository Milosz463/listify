package com.example.listify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
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
        String[]elementy={""};
        adapter=new ArrayAdapter<>(getContext(),R.layout.list_view_style,elementy);
        listViewNewLists.setAdapter(adapter);
        return view;
    }
}