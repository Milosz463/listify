
package com.example.listify;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import java.util.ArrayList;

public class FragmentListItems extends Fragment {
    Button buttonGoBack;
    ListView listViewProducts;
    ArrayAdapter<String> arrayAdapter;
    ProductsClass productsClass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list_items,container,false);

        buttonGoBack=view.findViewById(R.id.buttonGoBack);
        AppCompatButton buttonOptions=view.findViewById(R.id.ButtonOptions);
        listViewProducts=view.findViewById(R.id.listViewProducts);

        if(getArguments()!=null){
            productsClass=(ProductsClass) getArguments().getSerializable("products");
        }
        arrayAdapter=new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,productsClass.getListOfProducts());
        listViewProducts.setAdapter(arrayAdapter);

        buttonGoBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoBack(view);
                    }
                }
        );

        buttonOptions.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popupMenu=new PopupMenu(requireContext(),v);
                        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                        popupMenu.show();
                    }
                }
        );

        listViewProducts.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView textView=(TextView)view;
                        if(textView.getPaintFlags()!=Paint.STRIKE_THRU_TEXT_FLAG){
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        }else{
                            textView.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                        }

                    }
                }
        );
        listViewProducts.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        productsClass.removeProduct(position);
                        arrayAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );

        return view;


    }
    public void GoBack(View view){
        Navigation.findNavController(view).navigate(R.id.action_fragmentListItems_to_homeFragment);
    }
}

