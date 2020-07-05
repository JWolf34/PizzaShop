package shop.menu;

import shop.menu.pizza.Pizza;
import shop.menu.pizza.topping.Topping;
import shop.menu.pizza.topping.cheese.Cheese;
import shop.menu.pizza.topping.sauce.Sauce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Creates, edits, and displays the order of a customer at PizzaShop.
 */
public class Order {

    Menu menu;
    List<MenuItem> orderItems;

    /**
     * Creates a new instance of {@code Order}.
     *
     * Initialize <var>menu</var> to singleton instance of {@link Menu}.
     * Initialize <var>orderItems</var> as empty {@code ArrayList<>} for {@link MenuItem} objects
     * to be inserted into.
     */
    public Order(){

        menu = Menu.getInstance();
        orderItems =  new ArrayList<>();
    }

    /**
     * Adds {@link MenuItem} {@param item} to the order.
     *
     * Adds {@param item} to <var>orderItems</var> and prints a confirmation to the console.
     *
     * @param item the {@link MenuItem} to be added to the order.
     */
    public void addItem(MenuItem item){
        orderItems.add(item);
        System.out.format("%s has been added to your order.\n", item.toString());
    }

    /**
     * Initializes a text-based menu to receive and interpret user input to add an item to the order.
     *
     * Lists the options of types of foods available on the menu. User input of a number decides a
     * method call to add a certain item of the corresponding type to the order.
     */
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

    /**
     * Removes a {@link MenuItem}from the order (<var>orderItems</var>) at the given index. Prints a
     * confirmation to the console.
     *
     * @param index The index of the {@link MenuItem} to be removed from <var>orderItems</var>
     */
    public void removeItem(int index){
        MenuItem removedItem = orderItems.get(index);
        orderItems.remove(index);
        System.out.format("%s has been removed from your order.\n", removedItem.toString());
    }

    /**
     * Initializes a text-based menu to receive and interpret user input to remove an item to the order.
     *
     * Displays order items in the order in which they were added. The user inputs the number option
     * of the item to be removed and the item is removed from the order via {@link #removeItem(int)}.
     */
    public void dialogueRemoveItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item would you like to remove from your order?\n");
        int index;

        while(true){
            List<MenuItem> items = getOrderItems();
            for(int i = 0; i < items.size(); i++){
                System.out.format("%d. $%.2f: %s\n", i+1, items.get(i).getPrice(), items.get(i).toString());
            }

            System.out.print("\nEnter a number: ");
            int input = scanner.nextInt();
            System.out.println();

            if(input >= 0 && input < items.size()){
                index = input;
                break;
            }
            else{
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        removeItem(index);
    }

    /**
     * Return class variable <var>orderItems</var>.
     * @return <var>orderItems</var>
     */
    private List<MenuItem> getOrderItems(){
        return orderItems;
    }

    /**
     * Returns the sum of the prices of all {@link MenuItem} objects in <var>orderItems</var>.
     *
     * @return the sum of the prices of all {@link MenuItem} objects in <var>orderItems</var>.
     */
    public double getOrderTotal(){
        return  orderItems.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    /**
     * Initializes a text-based menu to receive and interpret user input to add a {@link Pizza} to the order.
     *
     * Loops through asking user input for {@link Pizza} type, size, sauce topping, cheese topping,
     * and additional toppings. Once all preferences for the {@link Pizza} have been recorded, the
     * {@link Pizza} object is added to the order <var>orderItems</var> via {@link #addItem(MenuItem)}.
     */
    public void addPizza(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which type of pizza would you like?\n");
        Pizza newPizza;

        //Choose pizza type
        while(true){
            List<MenuItem> pizzas = menu.getMenuItemList().get("Pizza");
            for(int i = 0; i < pizzas.size(); i++) {
                System.out.format("%d. %s\n", i+1, pizzas.get(i).getItemName());
            }
            System.out.print("\nEnter a number: ");
            int input = scanner.nextInt();
            System.out.println();
            try{
                newPizza = (Pizza)pizzas.get(input-1);
                break;
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
            int input = scanner.nextInt();
            System.out.println();

            switch(input){
                case(1):
                    newPizza = newPizza.getNewPizza("S");
                    validPizzaSize = true;
                    break;
                case(2):
                    newPizza = newPizza.getNewPizza("M");
                    validPizzaSize = true;
                    break;
                case(3):
                    newPizza = newPizza.getNewPizza("L");
                    validPizzaSize = true;
                    break;
                case(4):
                    newPizza = newPizza.getNewPizza("XL");
                    validPizzaSize = true;
                    break;
                default:
                    System.out.println("\nInvalid input. Please enter a number");
            }
        }

        //Choose sauce
        System.out.format("What sauce would you like on your %s?\n\n", newPizza.getItemName());

        while(true){
            List<MenuItem> sauces = menu.getMenuItemList().get("Sauces");
            for(int i = 0; i < sauces.size(); i++) {
                System.out.format("%d. %s\n", i+1, sauces.get(i).getItemName());
            }
            System.out.print("\nEnter a number: ");
            int input = scanner.nextInt();
            System.out.println();
            try{
                Sauce sauce = (Sauce)sauces.get(input-1);
                newPizza.addTopping(sauce);
                break;
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        //Choose cheese
        System.out.format("What cheese would you like on your %s?\n\n", newPizza.getItemName());

        while(true){
            List<MenuItem> cheeses = menu.getMenuItemList().get("Cheeses");
            for(int i = 0; i < cheeses.size(); i++) {
                System.out.format("%d. %s\n", i+1, cheeses.get(i).getItemName());
            }
            System.out.print("\nEnter a number: ");
            int input = scanner.nextInt();
            System.out.println();
            try{
                Cheese cheese = (Cheese)cheeses.get(input-1);
                newPizza.addTopping(cheese);
                break;
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        //Choose toppings
        System.out.format("What toppings would you like on your %s?\n\n", newPizza.getItemName());

        while(true){
            List<MenuItem> toppings = menu.getMenuItemList().get("Toppings");
            for(int i = 0; i < toppings.size(); i++) {
                System.out.format("%d. %s\n", i+1, toppings.get(i).getItemName());
            }
            System.out.format("%d. Done", toppings.size() + 1);
            System.out.print("\nEnter a number: ");
            int input = scanner.nextInt();
            System.out.println();
            try{
                if(input == toppings.size() + 1){break;}

                Topping top = (Topping)toppings.get(input-1);
                newPizza.addTopping(top);
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        addItem(newPizza);
    }

    /**
     * Displays the current order.
     *
     * Loops through the contents of <var>orderItems</var> and displays the price and description of each
     * {@link MenuItem}. Finally, the sum total of all item prices on the order is printed to the console
     * via {@link #getOrderTotal()}.
     */
    public void show(){
        System.out.println("\nYour order: \n");

        for(MenuItem item : orderItems){
            System.out.format("$%.2f: %s\n", item.getPrice(), item.toString());
        }
        System.out.println("--------------------");
        System.out.format("Total: $%.2f\n", this.getOrderTotal());

    }

}
