package sg.edu.nus.iss.pizza.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Pizza {

    @NotBlank(message="Please select your pizza toppings.")
    private String pizzaType;

    @NotBlank(message="Please select the size for your pizza.")
    private String size;

    @Min(value=1, message="Minimum number of pizzas per order is 1.")
    @Max(value=10, message="Maximum number of pizzas per order is 10.")
    private Integer quantity;
    private String id;

    public Pizza() {
        this.id = UUID.randomUUID().toString();
    }

    public String getPizzaType() {
        return pizzaType;
    }
    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
       
}
