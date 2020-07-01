package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepDishPizza extends Pizza{

    double price;
    String size;
    List<String> toppings = new ArrayList<String>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    public DeepDishPizza(String size, String... toppings){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(this.size);

        if(toppings.length > 0){
            for (String top : toppings) {
                this.toppings.add(top);

            }
        }
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
        priceBySize.put("S", 10.00);
        priceBySize.put("M", 14.00);
        priceBySize.put("L", 18.00);
        priceBySize.put("XL", 22.00);
    }

    public String toString(){

        return String.join("", this.getSizeString(this.size), " deep dish pizza with ", String.join(", ", toppings));
    };
}
