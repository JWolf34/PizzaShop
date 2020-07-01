package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pizza {

    double price;
    String size;
    List<String> toppings = new ArrayList<String>();


    public abstract void addTopping(String top);

    public void cook(){
        //What do we do here
    };

    public abstract double getPrice();

    public abstract String getSize();

    public String getSizeString(String size){
        String sizeString = "Invalid pizza size";
        switch(size) {
            case "S":
                sizeString = "Small";
                break;
            case "M":
                sizeString = "Medium";
                break;
            case "L":
                sizeString = "Large";
                break;
            case "XL":
                sizeString = "Extra-large";
                break;
        }

        return sizeString;
    };

    //Populate
    abstract void populatePriceMap();

    @Override
    public abstract String toString();

}
