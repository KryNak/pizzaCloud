package pizza.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pizza.configuration.OrderProps;
import pizza.model.Order;
import pizza.model.User;
import pizza.repository.OrderRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;
    private OrderProps orderProps;

    @Autowired
    public OrderController(OrderRepository orderRepo, OrderProps orderProps) {
        this.orderRepo = orderRepo;
        this.orderProps = orderProps;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user){

        if (errors.hasErrors()) return "orderForm";

        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model){
        Pageable pageable = PageRequest.of(0, orderProps.getPageSize(), Sort.by("placedAt").and(Sort.by("id")));
        model.addAttribute("orders", orderRepo.findOrderByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }

}
