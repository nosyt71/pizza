package sg.edu.nus.iss.pizza.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.pizza.model.Pizza;

@Repository 
public class PizzaRepository {

    private List<Pizza> pizzaOrders = new ArrayList<>();

    public Pizza getPizza(int index) {
        return pizzaOrders.get(index);
    }

    public void addPizza(Pizza pizza) {
        pizzaOrders.add(pizza);
    }

    public void updatePizza(Pizza pizza, int index) {
        pizzaOrders.set(index, pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzaOrders;
    }
    
}
