package com.company;

public class GreenPepper extends Topping {

    final String name;
    final int calories;

    public GreenPepper(){
        this.name = "green pepper";
        this.calories = 15;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    public String toString(){
        return getName();
    }
}
