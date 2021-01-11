package pizza.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pizza.model.Order;
import pizza.model.Pizza;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private SimpleJdbcInsert orderInsert;
    private SimpleJdbcInsert orderPizzaInsert;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.orderInsert = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order")
                .usingGeneratedKeyColumns("id");

        this.orderPizzaInsert = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order_Pizzas");

        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {

        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Pizza> pizzas = order.getPizzas();
        for(Pizza pizza : pizzas){
            savePizzaToOrder(pizza, orderId);
        }

        return order;
    }

    private long saveOrderDetails(Order order){

        @SuppressWarnings("unchecked")
        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());

        return orderInsert
                .executeAndReturnKey(values)
                .longValue();
    }

    private void savePizzaToOrder(Pizza pizza, long orderId){
        Map<String, Object> values = new HashMap<>();
        values.put("pizzaOrder", orderId);
        values.put("pizza", pizza.getId());
        orderPizzaInsert.execute(values);
    }


}
