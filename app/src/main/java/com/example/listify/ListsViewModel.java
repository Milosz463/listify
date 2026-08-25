package com.example.listify;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListsViewModel extends ViewModel {

    private ArrayList<String> namesOfLists = new ArrayList<>();

    public ArrayList<String> getNamesOfLists() {
        return namesOfLists;
    }

    public void addList(String name) {
        namesOfLists.add(name);
    }
}
