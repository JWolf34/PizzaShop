package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Pizza {

    public void addTopping(String top);

    public void cook();

    public double getPrice();

    public String getSize();

    //Populate
    public void populatePriceMap();

    @Override
    public String toString();

}
