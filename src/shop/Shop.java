package shop;

import shop.menu.*;
import shop.menu.pizza.*;
import shop.menu.pizza.topping.*;

import javax.swing.plaf.basic.BasicMenuUI;

public class Shop {

    Menu menu;

    public Shop(){
        this.menu = new Menu();
        populateMenu();
        showMenu();
        run();
    };

    private void populateMenu(){
        this.menu.addItem(new NYStylePizza());
        this.menu.addItem(new DeepDishPizza());
        this.menu.addItem(new PanPizza());
        this.menu.addItem(new StuffedCrustPizza());

    }
    private void showMenu(){
        this.menu.show();
    }

    public void run(){

        Order order = new Order();

        Pizza NYPizzaMeat = new NYStylePizza("XL", new RedSauce(), new Cheese(), new Sausage(), new GreenPepper());
        order.addItem(NYPizzaMeat);

        Pizza pan = new PanPizza("L", new RedSauce(), new Cheese());
        order.addItem(pan);

        Pizza NYPizzaVeggie = new NYStylePizza("M", new RedSauce(), new Cheese(), new Mushroom(), new GreenPepper());
        order.addItem((NYPizzaVeggie));

        order.show();


    }
}
