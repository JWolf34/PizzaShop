package shop.menu.pizza.topping.cheese;

public class ParmesanCheese extends Cheese {

    final String name;
    final int calories;
    final double price;

    public ParmesanCheese(){
        this.name = "Parmesan Cheese";
        this.calories = 130;
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
