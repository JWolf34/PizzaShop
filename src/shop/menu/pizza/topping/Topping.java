package shop.menu.pizza.topping;

import shop.menu.MenuItem;

public abstract class Topping implements MenuItem {

    /**
     * Method to be overridden. Returns the price of a {@link MenuItem};
     *
     * @return the price of the given {@link MenuItem}
     */
    public abstract double getPrice();

    /**
     * Method to be overridden. Returns the calories of a {@link MenuItem};
     *
     * @return the calories of the given {@link MenuItem}
     */
    public abstract int getCalories();

    /**
     * Method to be overridden. Returns the readable class name of a {@link MenuItem};
     *
     * @return the readable class name of the given {@link MenuItem}
     */
    public abstract String getItemName();

    @Override
    public String toString(){
        return getItemName();
    };
}
