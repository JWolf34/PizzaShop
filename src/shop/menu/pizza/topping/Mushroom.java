package shop.menu.pizza.topping;

public class Mushroom extends Topping {

    final String name;
    final int calories;

    public Mushroom(){
        this.name = "mushroom";
        this.calories = 15;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    public String toString(){
        return getName();
    }
}
