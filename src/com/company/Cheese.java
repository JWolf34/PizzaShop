package com.company;

public class Cheese extends Topping {

    final String name;
    final int calories;

    public Cheese(){
        this.name = "cheese";
        this.calories = 100;
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
