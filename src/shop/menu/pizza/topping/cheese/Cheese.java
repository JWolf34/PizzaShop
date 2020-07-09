package shop.menu.pizza.topping.cheese;

import shop.menu.pizza.topping.Topping;

/**
 * Abstract class {@code Cheese} extends the {@link Topping} abstract class. Includes shared
 * functionality for all {@code Cheese} subclasses such as {@link MozzarellaCheese} and {@link ParmesanCheese}.
 */
public abstract class Cheese extends Topping {

    final String name;
    final int calories;
    final double price;

    /**
     * Creates a new {@code Cheese} instance. Should always be called from a {@code super()} call from a
     * {@code Cheese} subclass. Assigns values to <var>this.name</var>, <var>this.calories</var>, and
     * <var>this.price</var>.
     *
     *
     * @param name The name of the subclass instantiating {@code Cheese}
     * @param calories The number of calories in the sauce
     * @param price The price of the sauce
     */
    public Cheese(String name, int calories, double price){
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    /**
     * Get the name of the cheese.
     *
     * @return The name of the cheese
     */
    @Override
    public String getItemName() {
        return name;
    }

    /**
     * Get the number of calories in the cheese.
     *
     * @return The number of calories in the cheese
     */
    @Override
    public int getCalories() {
        return calories;
    }

    /**
     * Get the price of the cheese.
     *
     * @return The price of the cheese
     */
    @Override
    public double getPrice() { return price; }
}
