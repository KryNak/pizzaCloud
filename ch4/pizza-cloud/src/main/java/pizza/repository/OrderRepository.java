package pizza.repository;

import org.springframework.data.repository.CrudRepository;
import pizza.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {


}
