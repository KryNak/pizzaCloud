package pizza.repository;

import pizza.model.Ingredient;

import java.util.List;

public interface IngredientRepository {

    List<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);

}
