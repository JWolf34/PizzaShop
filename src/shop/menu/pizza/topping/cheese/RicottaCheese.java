package shop.menu.pizza.topping.cheese;

public class RicottaCheese extends Cheese {

    final String name;
    final int calories;
    final double price;

    public RicottaCheese(){
        this.name = "Ricotta Cheese";
        this.calories = 120;
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
