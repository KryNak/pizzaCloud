package pizza.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pizza.model.Pizza;

public interface PizzaRepository extends PagingAndSortingRepository<Pizza, Long> {


}
