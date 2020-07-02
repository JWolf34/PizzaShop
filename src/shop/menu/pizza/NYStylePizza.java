package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NYStylePizza extends Pizza {

    double price;
    String size;
    int calories;
    List<Topping> toppings = new ArrayList<Topping>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    /**
     * Blank constructor to initialize class for display from {@code Menu}.
     */
    public NYStylePizza(){};

    /**
     * Creates a NYStylePizza of size <var>size</var> and with toppings <var>toppings</var>.
     * Populates the
     *
     *
     * @param size The size of the pizza; S, M, L, or XL
     * @param toppings An option list of type Topping to put on the pizza
     */
    public NYStylePizza(String size, Topping... toppings){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(this.size);

        if(toppings.length > 0){
            for (Topping top : toppings) {
                this.toppings.add(top);

            }
        }
    }

    @Override
    public void addTopping(Topping top) {
        toppings.add(top);
    }

    @Override
    public void cook() {
        //What do we do here
    }

    @Override
    public double getPrice() {
        return this.price;
    };

    /**
     * Returns the size of the given pizza.
     *
     * @return The {@code Class} variable <var>size</var> which is the
     * size of the given pizza.
     */
    @Override
    public String getSize() {
        return this.size;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public String getItemName() {
        return "New York Style pizza";
    }

    @Override
    public Pizza getNewPizza(String size) {
        return new NYStylePizza(size);
    }

    public void populatePriceMap(){
        priceBySize.put("S", 8.00);
        priceBySize.put("M", 12.00);
        priceBySize.put("L", 16.00);
        priceBySize.put("XL", 20.00);
    }

    public String toString(){
        if(size == null){ return getItemName();}
        else{
            return String.format("%s New York Style pizza with %s", this.getSizeString(this.size), this.getToppingsString(this.toppings));
        }

    };
}
