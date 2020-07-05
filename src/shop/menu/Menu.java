package shop.menu;

import shop.menu.pizza.*;
import shop.menu.pizza.topping.cheese.*;
import shop.menu.pizza.topping.extra.GreenPepper;
import shop.menu.pizza.topping.extra.Mushroom;
import shop.menu.pizza.topping.extra.Sausage;
import shop.menu.pizza.topping.sauce.AlfredoSauce;
import shop.menu.pizza.topping.sauce.BarbecueSauce;
import shop.menu.pizza.topping.sauce.MarinaraSauce;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * A singleton class {@code Menu} where the menu of PizzaShop is created, edited, and displayed.
 * The singleton state of this class is useful to make sure all references to {@code Menu}
 * will always refer to the same <var>menuItemList</var> and will not populate the
 * List with unique {@link MenuItem} objects.
 */
public class Menu {

    private static Menu menuInstance = null;
    final String[] itemTypes;
    Map<String, List<MenuItem>> menuItemList;

    /**
     * Constructs the singleton instance of {@code Menu}.
     *
     * Populates <var>itemTypes</var> with an
     * exhaustive list of all subtypes of {@link MenuItem} that will appear on the menu.
     *
     * Initialize <var>menuItemList</var> as a {@code HashMap<String, List<MenuItem>>}.
     *
     * Iterate through <var>itemTypes</var> and put values in <var>menuItemList</var> with keys of the String elements
     * in <var>itemTypes</var> and values of empty {@code ArrayList<MenuItem>} to be added to
     * later via the {@link #addItem(String, MenuItem) addItem} method.
     *
     * Populate the {@code ArrayList<MenuItem>} values in <var>menuItemList</var> via {@link #populateMenu()}.
     */
    private Menu(){
        itemTypes =  new String[]{"Pizza", "Sauces", "Cheeses", "Toppings"};
        menuItemList = new HashMap<>();
        for(String type : itemTypes){
            menuItemList.put(type, new ArrayList<>());
        }
        populateMenu();
    }

    /**
     * Adds a new item to <var>this.menuItemList</var>.
     *
     * If {@param type} does not exist in the keys of <var>this.menuItemList</var>, then the item will not
     * be added to <var>this.menuItemList</var> because its type is not supported on the menu.
     *
     * Else, add {@link MenuItem} {@param item} to the {@code ArrayList<>} value of the corresponding key
     * {@param type} in <var>this.menuItemList</var>.
     *
     * @param type The types of item ({@code HashMap} key) of the given {@link MenuItem} {@param item}.
     * @param item The {@link MenuItem} to be added to the menu.
     */
    public void addItem(String type, MenuItem item){
        if(!this.menuItemList.containsKey(type)){
            System.out.println("Invalid item type. Please enter a valid item type or create a new one.");
        }
        else {
            this.menuItemList.get(type).add(item);
        }
    }

    /**
     * Populates <var>this.menuItemList</var> via the {@link #addItem(String, MenuItem) addItem} method.
     *
     * As of now, the method requires manual insertion of new types and {@link MenuItem} objects into
     * the menu for display.
     */
    private void populateMenu(){
        //Pizza
        addItem("Pizza", new NYStylePizza());
        addItem("Pizza", new DeepDishPizza());
        addItem("Pizza", new PanPizza());
        addItem("Pizza", new StuffedCrustPizza());

        //Toppings

        //Sauces
        addItem("Sauces", new MarinaraSauce());
        addItem("Sauces", new BarbecueSauce());
        addItem("Sauces", new AlfredoSauce());

        //Cheeses
        addItem("Cheeses", new CheddarCheese());
        addItem("Cheeses", new MozzarellaCheese());
        addItem("Cheeses", new ParmesanCheese());
        addItem("Cheeses", new RicottaCheese());
        addItem("Cheeses", new RomanoCheese());

        //Extras
        addItem("Toppings", new Sausage());
        addItem("Toppings", new Mushroom());
        addItem("Toppings", new GreenPepper());

    }

    /**
     * Returns <var>menuItemList</var>
     * @return <var>menuItemList</var>
     */
    public Map<String, List<MenuItem>> getMenuItemList(){
        return menuItemList;
    }

    /**
     * Displays the contents of the menu via print to console.
     *
     * Iterates through each key of <var>this.menuItemList</var> and prints it to the console. Used
     * to separate menu into subsections.
     *
     * Then iterates through {@code ArrayList<>} values of each key, printing them to console under
     * their corresponding key headers.
     */
    public void show(){
        System.out.println("PizzaShop Menu \n");

        //Display menu items
        for(String key : menuItemList.keySet()){
            System.out.format("%s:\n", key);
            for(MenuItem item : menuItemList.get(key)){
                System.out.format("     %s", item.getItemName());
            }
            System.out.println("\n");
        }

    }

    /**
     * Returns the singleton instance of {@code Menu}. If it has not yet been instantiated, it will do so
     * and return a new singleton {@code Menu}.
     *
     * @return the singleton instance of {@code Menu}
     */
    public static Menu getInstance(){
        if(menuInstance == null){
            menuInstance = new Menu();
        }

        return menuInstance;
    }


}
