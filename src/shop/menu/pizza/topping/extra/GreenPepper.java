package shop.menu.pizza.topping.extra;

import shop.menu.pizza.topping.Topping;

public class GreenPepper extends Topping {

    final String name;
    final int calories;
    final double price;

    public GreenPepper(){
        this.name = "Green Pepper";
        this.calories = 15;
        this.price = 0.50;
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

    public String toString(){
        return getItemName();
    }
}
