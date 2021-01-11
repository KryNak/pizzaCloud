package pizza.repository;

import pizza.model.Order;

public interface OrderRepository {

    Order save(Order order);

}
