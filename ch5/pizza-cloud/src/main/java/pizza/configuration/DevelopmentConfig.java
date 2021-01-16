package pizza.configuration;

import com.google.common.collect.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import pizza.model.Ingredient;
import pizza.model.Order;
import pizza.model.Pizza;
import pizza.model.User;
import pizza.repository.IngredientRepository;
import pizza.repository.OrderRepository;
import pizza.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Profile("dev")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepo, IngredientRepository ingredientRepo,
                                        OrderRepository orderRepo, PasswordEncoder encoder){
        return args -> {

            User sa = new User("sa", encoder.encode("12345"), "Michal Blat",
                    "Hoza 105", "Katowice", "Podlasie","00-002","999888777");

            userRepo.save(sa);


            List<Ingredient> ingredients = Arrays.asList(
                    new Ingredient("TNPD", "thin pizza dough", Ingredient.Type.valueOf("PIZZA_DOUGH")),
                    new Ingredient("TKPD", "tick pizza dough", Ingredient.Type.valueOf("PIZZA_DOUGH")),
                    new Ingredient("MIBF", "beef mince", Ingredient.Type.valueOf("PROTEIN")),
                    new Ingredient("CUCH", "cuts of chicken", Ingredient.Type.valueOf("PROTEIN")),
                    new Ingredient("TMTO", "sliced tomato", Ingredient.Type.valueOf("VEGGIES")),
                    new Ingredient("LETC", "lettuce", Ingredient.Type.valueOf("VEGGIES")),
                    new Ingredient("GOUD", "gouda", Ingredient.Type.valueOf("CHEESE")),
                    new Ingredient("CHED", "cheddar", Ingredient.Type.valueOf("CHEESE")),
                    new Ingredient("KECH", "ketchup", Ingredient.Type.valueOf("SAUCE")),
                    new Ingredient("SALS", "salsa", Ingredient.Type.valueOf("SAUCE")));

            ingredientRepo.saveAll(ingredients);

            List<Order> orders = Arrays.asList(
                    new Order(1L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(2L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(3L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(4L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(5L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(6L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(7L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(8L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(9L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(10L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(11L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(12L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(13L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(14L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(15L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(16L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(17L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(18L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(19L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(20L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(21L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(22L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(23L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(24L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(25L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(26L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(27L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(28L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa),
                    new Order(29L, new Date(), "Marek Bochenek", "Mlekowa 10", "Pedzisk", "Podlasie", "11-589", "6011728117614750", "04/27", "404", Collections.emptyList(), sa));

            orderRepo.saveAll(orders);
        };
    }

}
