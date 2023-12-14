package sg.edu.nus.iss.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.pizza.model.Pizza;
import sg.edu.nus.iss.pizza.repo.PizzaRepository;

@Service
public class PizzaService {

    @Autowired
    PizzaRepository pizzaRepository;

    public Pizza getPizza(int index) {
        return pizzaRepository.getPizzas().get(index);
    }

    public void addPizza (Pizza pizza) {
        pizzaRepository.getPizzas().add(pizza);
    }

    public void updatePizza(Pizza pizza, int index) {
        pizzaRepository.getPizzas().set(index, pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzaRepository.getPizzas();
    }

    public int getPizzaIndex(String id) {
        for (int i = 0; i < getPizzas().size(); i++) {
            if (getPizzas().get(i).getId().equals(id)) return i;
        }
        return -1000;
    }

    public Pizza getPizzaById(String id) {
        int index = getPizzaIndex(id);
        return index == -1000 ? new Pizza() : getPizza(index);
    }
    
    public void submitOrder(Pizza pizza) {
        int index = getPizzaIndex(pizza.getId());
        if (index == -1000) {
            addPizza(pizza);
        } else {
            updatePizza(pizza, index);
        }
    }
}
