package sg.edu.nus.iss.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.pizza.model.Pizza;
import sg.edu.nus.iss.pizza.service.PizzaService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path="/")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @GetMapping(path="/")
    public String getHome(Model model,@RequestParam(required = false) String id) {
        model.addAttribute("pizza", new Pizza());
        return "index";
    }

    @PostMapping(path="/handleOrder")
    public String submitOrder(@Valid Pizza pizza, BindingResult result) {
        if (result.hasErrors()) {return "index";}
        else {
        pizzaService.submitOrder(pizza);
        return "redirect:/success";}
    }

    @GetMapping("/success")
    public String getOrder(Model model) {
        model.addAttribute("pizzas", pizzaService.getPizzas());
        return "success";
    }
    
    
}
