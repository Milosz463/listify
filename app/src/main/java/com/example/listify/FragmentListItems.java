
package com.example.listify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

public class FragmentListItems extends Fragment {
    Button buttonGoBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list_items,container,false);

        buttonGoBack=view.findViewById(R.id.buttonGoBack);

        buttonGoBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoBack(view);
                    }
                }
        );

        return view;


    }
    public void GoBack(View view){
        Navigation.findNavController(view).navigate(R.id.action_fragmentListItems_to_homeFragment);
    }
}

