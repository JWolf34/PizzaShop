package shop.menu.pizza;

import shop.menu.MenuItem;
import shop.menu.pizza.topping.Topping;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pizza implements MenuItem {

    double price;
    String size;
    int calories;
    List<Topping> toppings = new ArrayList<Topping>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    /**
     * Blank constructor to initialize class for display from {@code Menu}.
     */
    public Pizza (){};

    /**
     * Pizza Constructor Template.
     *
     * Serves as a constructor template for all class extensions. A master constructor
     * to base all further extensions' constructors off of.
     *
     * @param size The size of the pizza; S, M, L, or XL
     * @param toppings An option list of type Topping to put on the pizza
     */
    public Pizza(String size, Topping... toppings){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(this.size);

        if(toppings.length > 0){
            for (Topping top : toppings) {
                this.toppings.add(top);

            }
        }
    };

    /**
     * Abstract method for all extensions.
     *
     * Adds a {@code Topping} <var>top</var> to the class List variable <var>toppings</var>.
     *
     * @param top The {@code Topping} to be added to the <var>toppings</var> list
     */
    public abstract void addTopping(Topping top);

    public void cook(){
        //What do we do here
    };

    public abstract double getPrice();

    public abstract String getSize();

    public abstract int getCalories();

    public abstract String getItemName();

    /**
     * Returns a longer String that is represented by the single char {@param size}. Used for
     * readability and printing purposes.
     *
     * @param size The single char string representation of the size of a given pizza
     * @return A String corresponding to the shorthand {@param size}
     */
    public String getSizeString(String size){
        String sizeString = "Invalid pizza size";
        switch(size) {
            case "S":
                sizeString = "Small";
                break;
            case "M":
                sizeString = "Medium";
                break;
            case "L":
                sizeString = "Large";
                break;
            case "XL":
                sizeString = "Extra-large";
                break;
        }

        return sizeString;
    };

    public String getToppingsString(List<Topping> tops){
        StringBuilder sb = new StringBuilder();
        String delim = ", ";

        for(Topping top : tops){
            if(top.getName() != tops.get(tops.size()-1).getName()){
                sb.append(top.getName());
                sb.append(delim);
            }
            else{
                sb.append("and ");
                sb.append(top.getName());
            }
        }
        return sb.toString();
    }

    //Populate
    abstract void populatePriceMap();

    @Override
    public abstract String toString();

}
