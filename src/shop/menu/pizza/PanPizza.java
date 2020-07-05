package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

public class PanPizza extends Pizza {

    /**
     * Blank constructor to initialize instance for display in class {@code Menu}
     */
    public PanPizza(){
        super();
    };

    /**
     * Creates an instance of PanPizza of size {@param size} and with toppings {@param toppings}.
     * Assigns a <var>price</var> to the {@code Pizza} depending on its {@param size} via the
     * {@link #priceBySize(String) priceBySize} method.
     *
     * @param size The size of the {@code Pizza}; S, M, L, or XL
     * @param toppings An option list of type Topping to put on the pizza
     */
    public PanPizza(String size, Topping... toppings){
        super(size, toppings);
        super.setPrice(priceBySize(size));
    }

    /**
     * Get the readable class name of the {@code Pizza}.
     * @return The readable class name of the {@code Pizza}
     */
    @Override
    public String getItemName() {
        return "Pan Pizza";
    }

    /**
     * Returns an instance of {@code PanPizza} with given size {@param size}.
     *
     * @param size The size of the new {@Pizza}. S, M, L, or XL.
     *
     * @return A new instance of {@code PanPizza} with given size {@param size}.
     */
    @Override
    public Pizza getNewPizza(String size) {
        return new PanPizza(size);
    }

    /**
     * Get the price of a {@code PanPizza} given a size {@param size}.
     *
     * @param size The single char String representation of the size of a {@code Pizza}; S, M, L, or XL.
     *
     * @return The base price of a {@code PanPizza} given a size {@param size}
     */
    @Override
    public double priceBySize(String size){
        double price = -1;

        switch(size){
            case("S"):
                price = 10.00;
                break;
            case("M"):
                price = 14.00;
                break;
            case("L"):
                price = 18.00;
                break;
            case("XL"):
                price = 22.00;
                break;
        }
        return price;
    }
}
