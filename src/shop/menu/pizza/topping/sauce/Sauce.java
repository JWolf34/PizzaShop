package shop.menu.pizza.topping.sauce;

import shop.menu.pizza.topping.Topping;

public abstract class Sauce extends Topping {

    final String name;
    final int calories;
    final double price;

    public Sauce(String name, int calories, double price){
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public double getPrice() { return price; }
}
