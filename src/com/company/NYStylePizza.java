package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NYStylePizza extends Pizza {

    double price;
    String size;
    List<String> toppings = new ArrayList<String>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    public NYStylePizza(String size){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(this.size);
    }

    @Override
    public void addTopping(String top) {
        toppings.add(top);
    }

    @Override
    public void cook() {
        //What do we do here
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSize() {
        return size;
    }

    public void populatePriceMap(){
        priceBySize.put("S", 8.00);
        priceBySize.put("M", 12.00);
        priceBySize.put("L", 16.00);
        priceBySize.put("XL", 20.00);
    }

    public String toString(){

        return String.join("", this.getSizeString(this.size), " New York Style pizza with ", String.join(", ", toppings));
    };
}
