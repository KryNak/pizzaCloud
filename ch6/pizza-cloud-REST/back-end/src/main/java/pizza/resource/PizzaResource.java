package pizza.resource;

import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import pizza.model.Pizza;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Relation(value = "pizza", collectionRelation = "pizzas")
public class PizzaResource extends RepresentationModel<PizzaResource> {

    private static final IngredientResourceAssembler ingredientAssembler = new IngredientResourceAssembler();

    @Getter
    private String name;

    @Getter
    private Date createdAt;

    @Getter
    private List<IngredientResource> ingredients;

    public PizzaResource(Pizza pizza) {
        this.name = pizza.getName();
        this.createdAt = pizza.getCreatedAt();
        this.ingredients = new ArrayList<>(new IngredientResourceAssembler().toCollectionModel(pizza.getIngredients()).getContent());
    }
}
