package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepDishPizza extends Pizza{

    double price;
    String size;
    List<Topping> toppings = new ArrayList<Topping>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    public DeepDishPizza(String size, Topping... toppings){
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
    }

    @Override
    public String getSize() {
        return this.size;
    }

    public void populatePriceMap(){
        priceBySize.put("S", 10.00);
        priceBySize.put("M", 14.00);
        priceBySize.put("L", 18.00);
        priceBySize.put("XL", 22.00);
    }

    public String toString(){
        return String.format("%s deep dish pizza with %s", this.getSizeString(this.size), this.getToppingsString(this.toppings));
    };
}
