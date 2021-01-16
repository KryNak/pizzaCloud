package pizza.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import pizza.model.Order;
import pizza.model.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findOrderByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
