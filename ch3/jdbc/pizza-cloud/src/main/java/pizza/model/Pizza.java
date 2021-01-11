package pizza.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Pizza {

    private Long id;
    private Date createdAt;

    @NotNull
    @Size(min = 5, message =  "The name must be 5 characters long.")
    private String name;

    @NotEmpty(message = "You have to at least choose 1 ingredient")
    //@Size(min = 1, message = "You have to at least choose 1 ingredient")
    private List<Ingredient> ingredients;

}
