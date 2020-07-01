package shop.menu;

import shop.menu.pizza.Pizza;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.stream.Collectors;

public class Menu {

    final String[] itemTypes;
    Map<String, List<MenuItem>> menuItemList;

    public Menu(){
        itemTypes =  new String[]{"Pizza", "Sauces", "Cheeses", "Toppings"};
        menuItemList = new HashMap<String, List<MenuItem>>();
        for(String type : itemTypes){
            menuItemList.put(type, new ArrayList<MenuItem>());
        }
    }

    public void addItem(String type, MenuItem item){
        if(!menuItemList.containsKey(type)){
            System.out.println("Invalid item type. Please enter a valid item type or create a new one.");
        }
        else {
            menuItemList.get(type).add(item);
        }
    }

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


}
