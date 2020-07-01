package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here



        Pizza NYPizza = new NYStylePizza("L", new RedSauce(), new Cheese());
        NYPizza.addTopping(new Mushroom());
        NYPizza.addTopping(new GreenPepper());
        System.out.println(NYPizza);
        System.out.format("$%.2f \n", NYPizza.getPrice());

        Pizza deepdish = new DeepDishPizza("XL", new RedSauce(), new Cheese());
        deepdish.addTopping(new Sausage());
        System.out.println(deepdish);
        System.out.format("$%.2f \n", deepdish.getPrice());








    }
}
