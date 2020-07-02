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

        this.size = size;
        this.price = -1;

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
    public void addTopping(Topping top){
        toppings.add(top);
    };

    public void cook(){
        //What do we do here
    };

    protected void setPrice(double p){
        if(price < 0){
            price = p;
        }
    }

    public double getPrice(){
        return price;
    };

    public String getSize(){
        return size;
    };

    public int getCalories(){
        return calories;
    };

    public abstract double priceBySize(String size);

    public abstract String getItemName();

    public abstract Pizza getNewPizza(String size);

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
            if(top.getItemName() != tops.get(tops.size()-1).getItemName()){
                sb.append(top.getItemName());
                sb.append(delim);
            }
            else{
                sb.append("and ");
                sb.append(top.getItemName());
            }
        }
        return sb.toString();
    }



    @Override
    public  String toString(){
        if(size == null){ return getItemName();}
        else{
            return String.format("%s %s with %s", this.getSizeString(this.size), this.getItemName(), this.getToppingsString(this.toppings));
        }
    };

}
