package pizza.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pizza.model.Order;
import pizza.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public Order putOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long id, @RequestBody Order patchOrder){
        Order order = orderRepo.findById(id).get();

        if(patchOrder.getDeliveryName() != null){
            order.setDeliveryName(patchOrder.getDeliveryName());
        }
        if(patchOrder.getDeliveryCity() != null){
            order.setDeliveryCity(patchOrder.getDeliveryCity());
        }
        if(patchOrder.getDeliveryState() != null){
            order.setDeliveryState(patchOrder.getDeliveryState());
        }
        if(patchOrder.getDeliveryStreet() != null){
            order.setDeliveryStreet(patchOrder.getDeliveryStreet());
        }
        if(patchOrder.getDeliveryZip() != null){
            order.setDeliveryZip(patchOrder.getDeliveryZip());
        }
        if(patchOrder.getCcCVV() != null){
            order.setCcCVV(patchOrder.getCcCVV());
        }
        if(patchOrder.getCcExpiration() != null){
            order.setCcExpiration(patchOrder.getCcExpiration());
        }
        if(patchOrder.getCcNumber() != null){
            order.setCcNumber(patchOrder.getCcNumber());
        }

        return orderRepo.save(order);
    }

    @DeleteMapping(path = "/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long id){
        try{
            orderRepo.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }
    }

}
