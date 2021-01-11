package pizza.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pizza.model.Ingredient;
import pizza.model.Ingredient.Type;
import pizza.model.Order;
import pizza.model.Pizza;
import pizza.repository.IngredientRepository;
import pizza.repository.PizzaRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepo;
    private PizzaRepository pizzaRepo;

    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepo, PizzaRepository pizzaRepo){
        this.ingredientRepo = ingredientRepo;
        this.pizzaRepo = pizzaRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("pizza") Pizza pizza, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()) {
            return "design";
        }

        Pizza saved = pizzaRepo.save(pizza);
        order.addPizza(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(e -> e.getType().equals(type))
                .collect(Collectors.toList());
    }

}
