package dev.steelthedev.WealthWatch.API.User.Repository;

import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
