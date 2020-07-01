package shop.menu.pizza.topping;

public class RedSauce extends Topping {
    final String name;
    final int calories;

    public RedSauce(){
        this.name = "red sauce";
        this.calories = 110;
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
