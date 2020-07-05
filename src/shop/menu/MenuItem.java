package shop.menu;

public interface MenuItem {

    /**
     * Method to be overridden. Returns the price of a {@link MenuItem};
     *
     * @return the price of the given {@link MenuItem}
     */
    double getPrice();

    /**
     * Method to be overridden. Returns the calories of a {@link MenuItem};
     *
     * @return the calories of the given {@link MenuItem}
     */
    int getCalories();

    /**
     * Method to be overridden. Returns the readable class name of a {@link MenuItem};
     *
     * @return the readable class name of the given {@link MenuItem}
     */
    String getItemName();

}
