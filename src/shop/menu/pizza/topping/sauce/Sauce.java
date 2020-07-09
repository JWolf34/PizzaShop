package shop.menu.pizza.topping.sauce;

import shop.menu.MenuItem;
import shop.menu.pizza.topping.Topping;
import shop.menu.pizza.topping.sauce.MarinaraSauce;
import shop.menu.pizza.topping.sauce.BarbecueSauce;

/**
 * Abstract class {@code Sauce} extends the {@link Topping} abstract class. Includes shared
 * functionality for all {@code Sauce} subclasses such as {@link MarinaraSauce} and {@link BarbecueSauce}.
 */
public abstract class Sauce extends Topping {

    final String name;
    final int calories;
    final double price;

    /**
     * Creates a new {@code Sauce} instance. Should always be called from a {@code super()} call from a
     * {@code Sauce} subclass. Assigns values to <var>this.name</var>, <var>this.calories</var>, and
     * <var>this.price</var>.
     *
     *
     * @param name The name of the subclass instantiating {@code Sauce}
     * @param calories The number of calories in the sauce
     * @param price The price of the sauce
     */
    public Sauce(String name, int calories, double price){
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    /**
     * Get the name of the sauce.
     *
     * @return The name of the sauce
     */
    @Override
    public String getItemName() {
        return name;
    }

    /**
     * Get the number of calories in the sauce.
     *
     * @return The number of calories in the sauce
     */
    @Override
    public int getCalories() {
        return calories;
    }

    /**
     * Get the price of the sauce.
     *
     * @return The price of the sauce.
     */
    @Override
    public double getPrice() { return price; }
}
