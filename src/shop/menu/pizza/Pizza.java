package shop.menu.pizza;

import shop.menu.MenuItem;
import shop.menu.pizza.topping.Topping;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class {@code Pizza} implements the {@link MenuItem} interface. Includes shared functionality
 * for all {@code Pizza} subclasses such as {@link NYStylePizza} and {@link DeepDishPizza}.
 */
public abstract class Pizza implements MenuItem {

    double price;
    String size;
    int calories;
    List<Topping> toppings = new ArrayList<Topping>();

    /**
     * Blank constructor to initialize class for display from {@link Menu}.
     */
    public Pizza (){};

    /**
     * Create a new Pizza instance. Should always be called by a super() call from a {@code Pizza} subclass
     * constructor. Assigns a value to <var>this.size</var> and sets default value of <var>this.price</var>.
     *
     * <var>this.price</var> will be updated to a positive value via the subclass's override of the
     * {@link #setPrice(double) setPrice} abstract method which is called from the subclass's constructor.
     *
     * Vararg {@param toppings} is a list of {@link Topping} of variable length. If there exists at least
     * one {@link Topping} object in the list, the constructor will iterate through it and add the
     * {@link Topping} to the <var>this.toppings</var> class variable via the {@link #addTopping(Topping)
     * addTopping} method.
     *
     *
     * @param size The size of the pizza; S, M, L, or XL
     * @param toppings An optional list of type Topping to be put on the pizza
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
     * Adds a given {@link Topping} {@param top} to the <var>this.toppings</var> class variable.
     *
     * @param top The {@link Topping} object to be added to the <var>toppings</var> list
     */
    public void addTopping(Topping top){
        toppings.add(top);
    };

    /**
     * Not sure what to do here yet. Placeholder method in the event it becomes useful later
     */
    public void cook(){
        //What do we do here
    };

    /**
     * Assigns a value {@param p} to <var>this.price</var>. If <var>this.price</var> is less than
     * 0 (specifically its default placeholder value of -1), assign the value of <var>this.price</var>
     * to {@param p}. Else, leave <var>this.price</var> unchanged.
     * @param p
     */
    protected void setPrice(double p){
        if(price < 0){
            price = p;
        }
    }

    /**
     * Returns a double with value of <var>this.price</var>.
     *
     * @return double <var>this.price</var>
     */
    public double getPrice(){
        return price;
    };

    /**
     * Returns a String with the value of <var> this.size</var>.
     *
     * @return String <var>this.size</var>
     */
    public String getSize(){
        return size;
    };

    /**
     * Returns an int with the value of <var>this.calories</var>.
     *
     * @return int <var>this.calories</var>
     */
    public int getCalories(){
        return calories;
    };

    /**
     * Abstract method to be overridden by subclasses. Should return the price of a {@code Pizza} subclass given
     * its {@param size}.
     *
     * @param size The single char String representation of the size of a {@code Pizza}; S, M, L, or XL.
     * @return A double representing the price of the {@code Pizza}.
     */
    public abstract double priceBySize(String size);

    /**
     * Abstract method to be overridden by subclasses. Should return a String of a more readable version of the
     * class's name. Whereas {@link #toString()} toString} returns a compound string of the size, name, and
     * toppings of a {@code Pizza}, {@code #getItemName()} simply returns the name of the {@code Pizza}.
     *
     * @return A String representing the readable version of a {@code Pizza} subclass's class name.
     */
    public abstract String getItemName();

    /**
     * Abstract method to be overridden by subclasses. Should return a new instance of the {@code Pizza}
     * subclass instantiated with {@param size}.
     *
     * @param size The size of the new {@Pizza}. S, M, L, or XL.
     *
     * @return A new instance of the given {@Pizza} subclass.
     */
    public abstract Pizza getNewPizza(String size);

    /**
     * Returns a longer String that is represented by the single char {@param size}. Used for
     * readability and printing purposes.
     *
     * @param size The single char String representation of the size of a given {@code Pizza}.
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

    /**
     * Builds a String of all {@link Topping} elements in {@param tops}. Iterates through each element of
     * {@param tops} and separates each element with a delimiter <var>delim</var>. For formatting,
     * the loop checks to see if the current {@link Topping} object is not equal to the final element
     * of {@param tops}. If the two ARE equal, delimit with "and " instead of <var>delim</var> and
     * append the final element to the built String.
     *
     * Return the concatenated String.
     *
     * @param tops The {@code List} of {@link Topping} to be iterated through
     * @return A concatenated String of all the elements in {@param tops}
     */
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

    /**
     * Override of {@link Object#toString()} method of class {@link Object}.
     *
     * If there is no value of <var>this.size</var>, return {@link #getItemName()}. If the {@code Pizza} had
     * been instantiated without a size, then the object is not used to display instance-specific information
     * to the user and {@link #toString()} is used to print the {@code Pizza}'s name.
     *
     * Otherwise, return a String of the following format:
     *      {@code "(size of Pizza) (name of Pizza) with (toppings String)"}
     *
     * @return The name of the {@code Pizza} if <var>this.size</var> == null, otherwise
     *         a concatenated String of the {@code Pizza}'s size, name, and toppings
     */
    @Override
    public  String toString(){
        if(this.size == null){ return getItemName();}
        else{
            return String.format("%s %s with %s", this.getSizeString(this.size), this.getItemName(), this.getToppingsString(this.toppings));
        }
    };

}
