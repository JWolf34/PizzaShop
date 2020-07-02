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
        menu.show();
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

        List<MenuItem> pizzas = menu.getMenuItemList().get("Pizza");

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
