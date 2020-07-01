package shop.menu.pizza.topping.sauce;

public class AlfredoSauce extends Sauce {
    final String name;
    final int calories;
    final double price;

    public AlfredoSauce(){
        this.name = "Alfredo Sauce";
        this.calories = 170;
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
