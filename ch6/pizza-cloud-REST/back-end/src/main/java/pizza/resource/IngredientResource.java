package pizza.resource;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import pizza.model.Ingredient;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    @Getter
    private final String name;

    @Getter
    private final Ingredient.Type type;

    public IngredientResource(Ingredient ingredient) {
        name = ingredient.getName();
        type = ingredient.getType();
    }
}
