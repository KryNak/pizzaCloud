package pizza.repository;

import org.springframework.data.repository.CrudRepository;
import pizza.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {


}
