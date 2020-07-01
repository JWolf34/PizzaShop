package shop.menu.pizza.topping.sauce;

public class BarbecueSauce extends Sauce {
    final String name;
    final int calories;
    final double price;

    public BarbecueSauce(){
        this.name = "Barbecue Sauce";
        this.calories = 160;
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
