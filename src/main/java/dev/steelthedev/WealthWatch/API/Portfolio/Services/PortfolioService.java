package dev.steelthedev.WealthWatch.API.Portfolio.Services;

import dev.steelthedev.WealthWatch.API.Portfolio.Model.Portfolio;
import dev.steelthedev.WealthWatch.API.Portfolio.Repository.PortfolioRepository;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {


    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public PortfolioService(PortfolioRepository portfolioRepository, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }


    public void create(Portfolio portfolio){
        portfolioRepository.save(portfolio);
    }

    public Iterable<Portfolio> getUserPortfolios(User user){
       return portfolioRepository.findAllByUser(user);
    }


}

