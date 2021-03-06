package pizza.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Pizza_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date placedAt;

    @NotBlank(message = "You have to type in your name")
    private String deliveryName;

    @NotBlank(message = "You have to type in your street")
    private String deliveryStreet;

    @NotBlank(message = "You have to type in your city")
    private String deliveryCity;

    @NotBlank(message = "You have to type in your state")
    private String deliveryState;

    @NotBlank(message = "You have to type in your zip")
    private String deliveryZip;

    @CreditCardNumber(message = "It isn't a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Input must be in format MM/RR")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV code")
    private String ccCVV;

    @ManyToMany(targetEntity = Pizza.class)
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    @PrePersist
    void placedAt(){
        this.placedAt = new Date();
    }

}
