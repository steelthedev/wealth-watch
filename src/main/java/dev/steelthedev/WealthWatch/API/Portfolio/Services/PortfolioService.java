package dev.steelthedev.WealthWatch.API.Portfolio.Services;

import dev.steelthedev.WealthWatch.API.Portfolio.Model.Portfolio;
import dev.steelthedev.WealthWatch.API.Portfolio.Model.PortfolioRequest;
import dev.steelthedev.WealthWatch.API.Portfolio.Repository.PortfolioRepository;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.Optional;

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

    public Iterable<Portfolio> getAll(){
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> getPortfolio(Long id){return portfolioRepository.findById(id);}

    public void deletePorfolio(Long id){
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        portfolio.ifPresent(portfolioRepository::delete);
    }

    public void editPorfolio(Long id, PortfolioRequest portfolioRequest){
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        if (portfolio.isPresent()){
            Portfolio portfolioObject = portfolio.get();
            portfolioObject.setName(portfolioRequest.name());
            portfolioObject.setDescription(portfolioRequest.description());
            portfolioRepository.save(portfolioObject);
        }
    }
}


