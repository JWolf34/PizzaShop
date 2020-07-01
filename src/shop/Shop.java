package shop;

import shop.menu.*;
import shop.menu.pizza.*;
import shop.menu.pizza.topping.cheese.*;
import shop.menu.pizza.topping.extra.GreenPepper;
import shop.menu.pizza.topping.extra.Mushroom;
import shop.menu.pizza.topping.extra.Sausage;
import shop.menu.pizza.topping.sauce.MarinaraSauce;

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

        Pizza NYPizzaMeat = new NYStylePizza("XL", new MarinaraSauce(), new MozzarellaCheese(), new Sausage(), new GreenPepper());
        order.addItem(NYPizzaMeat);

        Pizza pan = new PanPizza("L", new MarinaraSauce(), new ParmesanCheese(), new RomanoCheese());
        order.addItem(pan);

        Pizza NYPizzaVeggie = new NYStylePizza("M", new MarinaraSauce(), new RicottaCheese(), new Mushroom(), new GreenPepper());
        order.addItem((NYPizzaVeggie));

        order.show();


    }
}
