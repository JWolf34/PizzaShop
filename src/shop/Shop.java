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
import java.util.Scanner;

public class Shop {

    Menu menu;

    public Shop(){
        this.menu = Menu.getInstance();
        run();
    };


    private void showMenu(){
        this.menu.show();
    }

    public void run(){

        System.out.println("Welcome to PizzaShop! Please select an option below:\n");
        Order order = new Order();

        while(true){
            String input = displayHomeOptions();

            switch(input){
                case("1"): //Show menu
                    showMenu();
                    break;
                case("2"): //Start new order
                    order = new Order();
                    order.dialogueAddItem();
                    break;
                case("3"): //View current order
                    order.show();
                    break;
                case("4"): //Add to order
                    order.dialogueAddItem();
                    break;
                case("5"): //Remove from order
                    order.dialogueRemoveItem();
                    break;
                case("6"): //Checkout
                    order.show();
                    System.out.println("\nThank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid entry. Please try again.\n");


            }

            
        }
    }

    public String displayHomeOptions(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Show Menu");
        System.out.println("2. Start new order");
        System.out.println("3. View current order");
        System.out.println("4. Add to order");
        System.out.println("5. Remove from order");
        System.out.println("6. Checkout");
        System.out.println();

        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        System.out.println();
        return input;

    }

}
