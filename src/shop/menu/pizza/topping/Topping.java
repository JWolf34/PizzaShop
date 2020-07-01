package shop.menu.pizza.topping;

public abstract class Topping {

    public abstract int getCalories();

    public abstract String getName();

    @Override
    public abstract String toString();
}
