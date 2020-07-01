package shop.menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Order {

    List<MenuItem> orderItems;

    public Order(){
        orderItems =  new ArrayList<>();
    }

    public void addItem(MenuItem item){
        orderItems.add(item);
        System.out.format("%s has been added to your order.\n", item.toString());
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

    public void show(){
        System.out.println("\nYour order: \n");

        for(MenuItem item : orderItems){
            System.out.format("$%.2f: %s\n", item.getPrice(), item.toString());
        }
        System.out.println("--------------------");
        System.out.format("Total: $%.2f\n", this.getOrderTotal());

    }

}
