package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NYStylePizza extends Pizza {

    /**
     * Blank constructor to initialize instance for display in class {@code Menu}
     */
    public NYStylePizza(){
        super();
    };

    /**
     * Creates an instance of NYStylePizza of size {@param size} and with toppings {@param toppings}.
     * Assigns a <var>price</var> to the {@code Pizza} depending on its {@param size} via the
     * {@link #priceBySize(String) priceBySize} method.
     *
     * @param size The size of the {@code Pizza}; S, M, L, or XL
     * @param toppings An option list of type Topping to put on the pizza
     */
    public NYStylePizza(String size, Topping... toppings){
        super(size, toppings);
        super.setPrice(priceBySize(size));
    }

    /**
     * Get the readable class name of the {@code Pizza}.
     * @return The readable class name of the {@code Pizza}
     */
    @Override
    public String getItemName() {
        return "New York Style Pizza";
    }

    /**
     * Returns an instance of {@code NYStylePizza} with given size {@param size}.
     *
     * @param size The size of the new {@Pizza}. S, M, L, or XL.
     *
     * @return A new instance of {@code NYStylePizza} with given size {@param size}.
     */
    @Override
    public Pizza getNewPizza(String size) {
        return new NYStylePizza(size);
    }

    /**
     * Get the price of a {@code NYStylePizza} given a size {@param size}.
     *
     * @param size The single char String representation of the size of a {@code Pizza}; S, M, L, or XL.
     *
     * @return The base price of a {@code NYStylePizza} given a size {@param size}
     */
    @Override
    public double priceBySize(String size){
        double price = -1;

        switch(size){
            case("S"):
                price = 8.00;
                break;
            case("M"):
                price = 12.00;
                break;
            case("L"):
                price = 16.00;
                break;
            case("XL"):
                price = 20.00;
                break;
        }
        return price;
    }
}
