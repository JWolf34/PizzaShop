package shop;

import shop.menu.Menu;
import shop.menu.pizza.*;
import shop.menu.pizza.topping.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Menu menu = new Menu();
        menu.addItem(new NYStylePizza());
        menu.addItem(new DeepDishPizza());
        menu.addItem(new PanPizza());
        menu.addItem(new StuffedCrustPizza());
        menu.show();

        System.out.println("\n\n\n");


        /*
        Pizza NYPizza = new NYStylePizza("L", new RedSauce(), new Cheese());
        NYPizza.addTopping(new Mushroom());
        NYPizza.addTopping(new GreenPepper());
        System.out.println(NYPizza);
        System.out.format("$%.2f \n", NYPizza.getPrice());

        Pizza deepdish = new DeepDishPizza("XL", new RedSauce(), new Cheese());
        deepdish.addTopping(new Sausage());
        System.out.println(deepdish);
        System.out.format("$%.2f \n", deepdish.getPrice());

         */








    }
}
