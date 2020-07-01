package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pizza {

    double price;
    String size;
    List<Topping> toppings = new ArrayList<Topping>();
    Map<String, Double> priceBySize = new HashMap<String, Double>();

    //Placeholder general constructor
    public Pizza (){};

    //Pizza Constructor Template
    public Pizza(String size, Topping... toppings){
        populatePriceMap();
        this.size = size;
        this.price = priceBySize.get(this.size);

        if(toppings.length > 0){
            for (Topping top : toppings) {
                this.toppings.add(top);

            }
        }
    };

    public abstract void addTopping(Topping top);

    public void cook(){
        //What do we do here
    };

    public abstract double getPrice();

    public abstract String getSize();

    public String getSizeString(String size){
        String sizeString = "Invalid pizza size";
        switch(size) {
            case "S":
                sizeString = "Small";
                break;
            case "M":
                sizeString = "Medium";
                break;
            case "L":
                sizeString = "Large";
                break;
            case "XL":
                sizeString = "Extra-large";
                break;
        }

        return sizeString;
    };

    public String getToppingsString(List<Topping> tops){
        StringBuilder sb = new StringBuilder();
        String delim = ", ";

        for(Topping top : tops){
            if(top.getName() != tops.get(tops.size()-1).getName()){
                sb.append(top.getName());
                sb.append(delim);
            }
            else{
                sb.append("and ");
                sb.append(top.getName());
            }
        }
        return sb.toString();
    }

    //Populate
    abstract void populatePriceMap();

    @Override
    public abstract String toString();

}
