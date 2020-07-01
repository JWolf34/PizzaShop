package shop;

import shop.menu.*;
import shop.menu.pizza.*;
import shop.menu.pizza.topping.cheese.*;
import shop.menu.pizza.topping.extra.GreenPepper;
import shop.menu.pizza.topping.extra.Mushroom;
import shop.menu.pizza.topping.extra.Sausage;
import shop.menu.pizza.topping.sauce.AlfredoSauce;
import shop.menu.pizza.topping.sauce.BarbecueSauce;
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
        //Pizza
        this.menu.addItem("Pizza", new NYStylePizza());
        this.menu.addItem("Pizza", new DeepDishPizza());
        this.menu.addItem("Pizza", new PanPizza());
        this.menu.addItem("Pizza", new StuffedCrustPizza());

        //Toppings

            //Sauces
        this.menu.addItem("Sauces", new MarinaraSauce());
        this.menu.addItem("Sauces", new BarbecueSauce());
        this.menu.addItem("Sauces", new AlfredoSauce());

            //Cheeses
        this.menu.addItem("Cheeses", new CheddarCheese());
        this.menu.addItem("Cheeses", new MozzarellaCheese());
        this.menu.addItem("Cheeses", new ParmesanCheese());
        this.menu.addItem("Cheeses", new RicottaCheese());
        this.menu.addItem("Cheeses", new RomanoCheese());

            //Extras
        this.menu.addItem("Toppings", new Sausage());
        this.menu.addItem("Toppings", new Mushroom());
        this.menu.addItem("Toppings", new GreenPepper());

    }
    private void showMenu(){
        this.menu.show();
    }

    public void run(){

        /*
        Order order = new Order();

        Pizza NYPizzaMeat = new NYStylePizza("XL", new MarinaraSauce(), new MozzarellaCheese(), new Sausage(), new GreenPepper());
        order.addItem(NYPizzaMeat);

        Pizza pan = new PanPizza("L", new MarinaraSauce(), new ParmesanCheese(), new RomanoCheese());
        order.addItem(pan);

        Pizza NYPizzaVeggie = new NYStylePizza("M", new MarinaraSauce(), new RicottaCheese(), new Mushroom(), new GreenPepper());
        order.addItem((NYPizzaVeggie));

        order.show();

         */


    }
}
