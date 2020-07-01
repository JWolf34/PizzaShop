package com.company;

public class Sausage extends Topping {

    final String name;
    final int calories;

    public Sausage(){
        this.name = "sausage";
        this.calories = 80;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return getName();
    }
}
