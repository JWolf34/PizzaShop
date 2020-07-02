package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StuffedCrustPizza extends Pizza {

    double price;
    String size;
    int calories;
    List<Topping> toppings = new ArrayList<Topping>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    /**
     * Blank constructor to initialize class for display from {@code Menu}.
     */
    public StuffedCrustPizza(){};

    public StuffedCrustPizza(String size, Topping... toppings){
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
    }

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
        return "Stuffed crust pizza";
    }

    @Override
    public Pizza getNewPizza(String size) {
        return new StuffedCrustPizza(size);
    }

    public void populatePriceMap(){
        priceBySize.put("S", 9.00);
        priceBySize.put("M", 13.00);
        priceBySize.put("L", 17.00);
        priceBySize.put("XL", 21.00);
    }

    public String toString(){
        return String.format("%s stuffed crust pizza with %s", this.getSizeString(this.size), this.getToppingsString(this.toppings));
    };
}
