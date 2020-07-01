package shop.menu;

import shop.menu.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.stream.Collectors;

public class Menu {

    List<MenuItem> menuItemList;

    public Menu(){
        menuItemList = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        menuItemList.add(item);
    }

    public void show(){
        System.out.println("PizzaShop Menu \n");
        System.out.println("Pizza:");

        //Display Pizza items
        List<MenuItem> pizzaItems = menuItemList.stream().filter(item -> item instanceof Pizza)
                .collect(Collectors.toList());
        pizzaItems.forEach(pizza -> System.out.format("     %s\n", pizza.getItemName()));

        //Add more MenuItems extensions as we create them

    }


}
