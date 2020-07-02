package shop.menu.pizza;

import shop.menu.pizza.topping.Topping;

public class PanPizza extends Pizza {

    /**
     * Blank constructor to initialize instance for display in {@code Menu}
     */
    public PanPizza(){
        super();
    };

    /**
     * Creates a NYStylePizza of size <var>size</var> and with toppings <var>toppings</var>.
     * Assigns a <var>price</var> to the pizza depending on its {@param size}.
     *
     * @param size The size of the pizza; S, M, L, or XL
     * @param toppings An option list of type Topping to put on the pizza
     */
    public PanPizza(String size, Topping... toppings){
        super(size, toppings);
        super.setPrice(priceBySize(size));
    }

    @Override
    public String getItemName() {
        return "Pan Pizza";
    }

    @Override
    public Pizza getNewPizza(String size) {
        return new PanPizza(size);
    }

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
