package pizza.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pizza.model.Ingredient;
import pizza.model.Pizza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Repository
public class JdbcPizzaRepository implements PizzaRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcPizzaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Pizza save(Pizza pizza) {

        long pizzaId = savePizzaInfo(pizza);
        pizza.setId(pizzaId);

        for(Ingredient ingredient : pizza.getIngredients()){
                saveIngredientToPizza(ingredient, pizzaId);
        }

        /*
        pizza.getIngredients()
                .stream()
                .map(this::findIngredientById)
                .forEach(ingredient -> saveIngredientToPizza(ingredient, pizzaId));

         */

        return pizza;
    }

    private long savePizzaInfo(Pizza pizza){

        pizza.setCreatedAt(new Date());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Pizza (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        ).newPreparedStatementCreator(
                Arrays.asList(
                        pizza.getName(),
                        new Timestamp(pizza.getCreatedAt().getTime())
                )
        );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);

        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToPizza(Ingredient ingredient, long pizzaId) {

        jdbc.update("" +
                "insert into Pizza_Ingredients values (?, ?)",
                pizzaId, ingredient.getId()
        );

    }

    /*
    private Ingredient findIngredientById(String id){
        return jdbc.queryForObject("select id, name, type from Ingredient where id = ?", this::mapToIngredient, id);
    }

    private Ingredient mapToIngredient(ResultSet resultSet, long rowNumb) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("type"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }

     */

}
