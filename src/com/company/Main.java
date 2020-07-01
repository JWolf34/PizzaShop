package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pizza NYPizza = new NYStylePizza("L");
        NYPizza.addTopping("red sauce");
        NYPizza.addTopping("parmesan cheese");
        NYPizza.addTopping("mushroom");
        NYPizza.addTopping("green pepper");
        System.out.println(NYPizza);
        System.out.format("$%.2f \n", NYPizza.getPrice());

        Pizza deepdish = new DeepDishPizza("XL");
        deepdish.addTopping("red sauce");
        deepdish.addTopping("mozzarella cheese");
        deepdish.addTopping("sausage");
        System.out.println(deepdish);
        System.out.format("$%.2f \n", deepdish.getPrice());




    }
}
