package shop.menu.pizza.topping.cheese;

import shop.menu.pizza.topping.Topping;

public abstract class Cheese extends Topping {

    final String name;
    final int calories;
    final double price;

    public Cheese(String name, int calories, double price){
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
