package JavaFundamentals;

import java.util.ArrayList;
import java.util.List;

public class PizzaClient {
    public List<PizzaBase> getPizzaBases() {
        PizzaBase pizzaBase1 = new PizzaBase(1, "cheese", 570.0);
        PizzaBase pizzaBase2 = new PizzaBase(2, "peppy panner", 600.0);
        ArrayList<PizzaBase> pizzaBases = new ArrayList<>();
        pizzaBases.add(pizzaBase1);
        pizzaBases.add(pizzaBase2);
        System.out.println("added all the pizza bases");
        return pizzaBases;
    }

    public List<PizzaTopping> getPizzaToppings() {
        PizzaTopping pizzaTopping1 = new PizzaTopping(10, "tomato", 1);
        PizzaTopping pizzaTopping2 = new PizzaTopping(20, "corn", 2);
        ArrayList<PizzaTopping> pizzaToppings = new ArrayList<>();
        pizzaToppings.add(pizzaTopping1);
        pizzaToppings.add(pizzaTopping2);
        System.out.println("added all the pizza toppings");
        return pizzaToppings;
    }
}
