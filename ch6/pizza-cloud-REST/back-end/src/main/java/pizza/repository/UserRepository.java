package pizza.repository;

import org.springframework.data.repository.CrudRepository;
import pizza.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
