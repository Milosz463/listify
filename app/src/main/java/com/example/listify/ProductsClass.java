package com.example.listify;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductsClass implements Serializable {
    ArrayList<String>listOfProducts=new ArrayList<>();

    public ArrayList<String> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ArrayList<String> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
    public void addProduct(String product){
        listOfProducts.add(product);
    }
}
