package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pizza NYPizza = new NYStylePizza("Large");
        NYPizza.addTopping("red sauce");
        NYPizza.addTopping("mozzarella cheese");
        NYPizza.addTopping("sausage");
        System.out.println(NYPizza);


    }
}
