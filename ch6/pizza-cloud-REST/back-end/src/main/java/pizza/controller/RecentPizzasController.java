package pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizza.configuration.OrderProps;
import pizza.model.Pizza;
import pizza.repository.PizzaRepository;
import pizza.resource.PizzaResource;
import pizza.resource.PizzaResourceAssembler;

import java.util.List;

@RepositoryRestController
//@RequestMapping(value = "/design", produces = "application/json")
//@CrossOrigin(origins = "*")
public class RecentPizzasController {
    private PizzaRepository pizzaRepo;
    private OrderProps orderProps;

    @Autowired
    public RecentPizzasController(PizzaRepository pizzaRepo, OrderProps orderProps, RepositoryEntityLinks entityLinks) {
        this.pizzaRepo = pizzaRepo;
        this.orderProps = orderProps;
    }

    /*
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza postPizza(@RequestBody Pizza pizza){
        return pizzaRepo.save(pizza);
    }

     */

    @GetMapping(path = "/pizzas/recent", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<PizzaResource>> recentPizzas(){
        PageRequest page = PageRequest.of(0, orderProps.getPageSize(), Sort.by("createdAt").descending());
        List<Pizza> pizzas = pizzaRepo.findAll(page).getContent();

        CollectionModel<PizzaResource> recentResources = new PizzaResourceAssembler().toCollectionModel(pizzas);

        Link link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(RecentPizzasController.class).recentPizzas())
                .withRel("recents");

        recentResources.add(link);

        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> tacoById(@PathVariable("id") Long id){
        Optional<Pizza> optionalPizza = pizzaRepo.findById(id);
        return optionalPizza
                .map(pizza -> new ResponseEntity<>(pizza, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

     */

}
