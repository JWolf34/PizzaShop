package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NYStylePizza implements Pizza {

    double price;
    String size;
    List<String> toppings = new ArrayList<String>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    public NYStylePizza(String size){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(size);
    }

    @Override
    public void addTopping(String top) {
        toppings.add(top);
    }

    @Override
    public void cook() {

    };

     @Override
     public double getPrice(){
         return price;
     };

     public String getSize(){
         return size;
     }
    public void populatePriceMap(){
        priceBySize.put("Small", 8.00);
        priceBySize.put("Medium", 12.00);
        priceBySize.put("Large", 16.00);
        priceBySize.put("Extra-Large", 20.00);
    }

    public String toString(){

        return String.join("", size, " New York Style pizza with ", String.join(", ", toppings));
    };
}
