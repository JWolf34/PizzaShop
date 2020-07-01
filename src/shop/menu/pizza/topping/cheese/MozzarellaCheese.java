package shop.menu.pizza.topping.cheese;

public class MozzarellaCheese extends Cheese {

    final String name;
    final int calories;
    final double price;

    public MozzarellaCheese(){
        this.name = "Mozzarella Cheese";
        this.calories = 150;
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
