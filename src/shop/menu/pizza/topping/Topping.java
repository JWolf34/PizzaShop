package shop.menu.pizza.topping;

import shop.menu.MenuItem;

public abstract class Topping implements MenuItem {

    public abstract double getPrice();

    public abstract int getCalories();

    public abstract String getItemName();

    @Override
    public abstract String toString();
}
