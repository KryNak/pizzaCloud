package pizza.resource;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import pizza.controller.RecentPizzasController;
import pizza.model.Pizza;

public class PizzaResourceAssembler extends RepresentationModelAssemblerSupport<Pizza, PizzaResource> {

    public PizzaResourceAssembler() {
        super(RecentPizzasController.class, PizzaResource.class);
    }

    @Override
    protected PizzaResource instantiateModel(Pizza pizza) {
        return new PizzaResource(pizza);
    }

    @Override
    public PizzaResource toModel(Pizza pizza) {
        return createModelWithId(pizza.getId(), pizza);
    }
}
