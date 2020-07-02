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
import java.util.logging.FileHandler;
import java.util.stream.Collectors;

public class Menu {

    private static Menu menuInstance = null;

    final String[] itemTypes;
    Map<String, List<MenuItem>> menuItemList;

    private Menu(){
        itemTypes =  new String[]{"Pizza", "Sauces", "Cheeses", "Toppings"};
        menuItemList = new HashMap<String, List<MenuItem>>();
        for(String type : itemTypes){
            menuItemList.put(type, new ArrayList<MenuItem>());
        }
        populateMenu();
    }

    public void addItem(String type, MenuItem item){
        if(!menuItemList.containsKey(type)){
            System.out.println("Invalid item type. Please enter a valid item type or create a new one.");
        }
        else {
            menuItemList.get(type).add(item);
        }
    }

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

    Map<String, List<MenuItem>> getMenuItemList(){
        return menuItemList;
    };

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

    public static Menu getInstance(){
        if(menuInstance == null){
            menuInstance = new Menu();
        }

        return menuInstance;
    }


}
