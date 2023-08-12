package dev.steelthedev.WealthWatch.API.Portfolio.Repository;

import dev.steelthedev.WealthWatch.API.Portfolio.Model.Portfolio;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {

    public Iterable<Portfolio> findAllByUser(User user);

}
