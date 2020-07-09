package shop.menu.pizza.topping.extra;

import shop.menu.pizza.topping.Topping;

/**
 * Abstract class {@code Extra} extends the {@link Topping} abstract class. Includes shared
 * functionality for all {@code Extra} subclasses such as {@link Sausage} and {@link Mushroom}.
 */
public abstract class Extra extends Topping {

    final String name;
    final int calories;
    final double price;


    /**
     * Creates a new {@code Extra} instance. Should always be called from a {@code super()} call from a
     * {@code Extra} subclass. Assigns values to <var>this.name</var>, <var>this.calories</var>, and
     * <var>this.price</var>.
     *
     *
     * @param name The name of the subclass instantiating {@code Cheese}
     * @param calories The number of calories in the sauce
     * @param price The price of the sauce
     */
    public Extra(String name, int calories, double price){
        this.name = name;
        this.calories = calories;
        this.price = price;
    }


    /**
     * Get the name of the topping.
     *
     * @return The name of the topping
     */
    @Override
    public String getItemName() {
        return name;
    }

    /**
     * Get the number of calories in the topping.
     *
     * @return The number of calories in the topping
     */
    @Override
    public int getCalories() {
        return calories;
    }

    /**
     * Get the price of the topping.
     *
     * @return The price of the topping.
     */
    @Override
    public double getPrice() { return price; }
}
