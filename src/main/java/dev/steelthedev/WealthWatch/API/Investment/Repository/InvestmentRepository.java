package dev.steelthedev.WealthWatch.API.Investment.Repository;

import dev.steelthedev.WealthWatch.API.Investment.Model.InvestmentTransaction;
import org.springframework.data.repository.CrudRepository;

public interface InvestmentRepository extends CrudRepository<InvestmentTransaction, Long> {

}
