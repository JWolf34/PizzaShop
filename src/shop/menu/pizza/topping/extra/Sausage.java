package shop.menu.pizza.topping.extra;

import shop.menu.pizza.topping.Topping;

public class Sausage extends Topping {

    final String name;
    final int calories;
    final double price;

    public Sausage(){
        this.name = "Sausage";
        this.calories = 80;
        this.price = 1.00;
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

    @Override
    public String toString() {
        return getItemName();
    }
}
