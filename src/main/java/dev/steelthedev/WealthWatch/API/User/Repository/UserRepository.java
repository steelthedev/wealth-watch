package dev.steelthedev.WealthWatch.API.User.Repository;

import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
