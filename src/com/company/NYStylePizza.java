package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NYStylePizza extends Pizza {

    double price;
    String size;
    List<Topping> toppings = new ArrayList<Topping>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    public NYStylePizza(String size, Topping... toppings){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(this.size);

        if(toppings.length > 0){
            for (Topping top : toppings) {
                this.toppings.add(top);

            }
        }
    }

    @Override
    public void addTopping(Topping top) {
        toppings.add(top);
    }

    @Override
    public void cook() {
        //What do we do here
    }

    @Override
    public double getPrice() {
       return this.price;
    };

    @Override
    public String getSize() {
        return this.size;
    }

    public void populatePriceMap(){
        priceBySize.put("S", 8.00);
        priceBySize.put("M", 12.00);
        priceBySize.put("L", 16.00);
        priceBySize.put("XL", 20.00);
    }

    public String toString(){

        return String.format("%s New York Style pizza with %s", this.getSizeString(this.size), this.getToppingsString(this.toppings));
    };
}
