package shop.menu.pizza.topping.cheese;

public class CheddarCheese extends Cheese {

    final String name;
    final int calories;
    final double price;

    public CheddarCheese(){
        this.name = "Cheddar Cheese";
        this.calories = 140;
        this.price = 0.0;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public double getPrice() { return price; }

    public String toString(){
        return getItemName();
    }
}
