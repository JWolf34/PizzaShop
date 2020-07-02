package shop.menu;

import shop.menu.pizza.Pizza;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    Menu menu;
    List<MenuItem> orderItems;

    public Order(){

        menu = Menu.getInstance();
        orderItems =  new ArrayList<>();
    }

    public void addItem(MenuItem item){
        orderItems.add(item);
        System.out.format("%s has been added to your order.\n", item.toString());
    }

    public void dialogueAddItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item would you like to add to your order?\n");
        System.out.println("1. Pizza");
        //System.out.println("2. Salad");
        //System.out.println("3. Appetizer");
        //System.out.println("4. Dessert");
        System.out.print("\nEnter a number: ");
        String input = scanner.nextLine();
        System.out.println();

        switch(input){
            case("1"):
                addPizza();
                break;
        }

    }

    public void removeItem(int index){
        MenuItem removedItem = orderItems.get(index);
        orderItems.remove(index);
        System.out.format("%s has been removed from your order.\n", removedItem.toString());
    }

    public double getOrderTotal(){
        double sum = orderItems.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();
        return sum;
    };

    public void addPizza(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which type of pizza would you like?\n");
        Pizza newPizza;
        boolean validPizzaType = false;

        //Choose pizza type
        while(!validPizzaType){
            List<MenuItem> pizzas = menu.getMenuItemList().get("Pizza");
            for(int i = 0; i < pizzas.size(); i++) {
                System.out.format("%d. %s\n", i+1, pizzas.get(i).getItemName());
            }
            System.out.print("\nEnter a number: ");
            int input = scanner.nextInt();
            System.out.println();
            try{
                newPizza = (Pizza)pizzas.get(input-1);
                validPizzaType = true;
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a number.");

            }
        }

        //Choose pizza size
        System.out.format("What size of %s would you like?\n\n", newPizza.getItemName());
        boolean validPizzaSize = false;
        while(!validPizzaSize){
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");
            System.out.println("4. Extra-Large");

            System.out.print("\nEnter a number: ");
            String input = scanner.nextLine();
            System.out.println();

            switch(input){
                case("1"):
                    newPizza = newPizza.getNewPizza("S");
                    validPizzaSize = true;
                    break;
                case("2"):
                    newPizza = newPizza.getNewPizza("M");
                    validPizzaSize = true;
                    break;
                case("3"):
                    newPizza = newPizza.getNewPizza("L");
                    validPizzaSize = true;
                    break;
                case("4"):
                    newPizza = newPizza.getNewPizza("XL");
                    validPizzaSize = true;
                    break;
                default:
                    System.out.println("\nInvalid input. Please enter a number");
            }
        }





    }

    public void show(){
        System.out.println("\nYour order: \n");

        for(MenuItem item : orderItems){
            System.out.format("$%.2f: %s\n", item.getPrice(), item.toString());
        }
        System.out.println("--------------------");
        System.out.format("Total: $%.2f\n", this.getOrderTotal());

    }

}
