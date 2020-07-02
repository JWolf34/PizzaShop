package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NYStylePizza extends Pizza {

    /**
     * Blank constructor to initialize instance for display in {@code Menu}
     */
    public NYStylePizza(){
        super();
    };

    /**
     * Creates a NYStylePizza of size <var>size</var> and with toppings <var>toppings</var>.
     * Assigns a <var>price</var> to the pizza depending on its {@param size}.
     *
     * @param size The size of the pizza; S, M, L, or XL
     * @param toppings An option list of type Topping to put on the pizza
     */
    public NYStylePizza(String size, Topping... toppings){
        super(size, toppings);
        super.setPrice(priceBySize(size));
    }

    @Override
    public String getItemName() {
        return "New York Style Pizza";
    }

    @Override
    public Pizza getNewPizza(String size) {
        return new NYStylePizza(size);
    }

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
