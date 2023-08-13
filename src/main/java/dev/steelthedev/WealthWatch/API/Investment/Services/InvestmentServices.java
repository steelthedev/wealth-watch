package dev.steelthedev.WealthWatch.API.Investment.Services;

import dev.steelthedev.WealthWatch.API.Auth.Services.AuthServices;
import dev.steelthedev.WealthWatch.API.Investment.Model.InvestmentRequest;
import dev.steelthedev.WealthWatch.API.Investment.Model.InvestmentTransaction;
import dev.steelthedev.WealthWatch.API.Investment.Model.TransactionType;
import dev.steelthedev.WealthWatch.API.Investment.Repository.InvestmentRepository;
import dev.steelthedev.WealthWatch.API.Portfolio.Model.Portfolio;
import dev.steelthedev.WealthWatch.API.Portfolio.Repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InvestmentServices {


    private final InvestmentRepository investmentRepository;
    private final AuthServices authServices;

    private final PortfolioRepository portfolioRepository;


    public InvestmentServices(InvestmentRepository investmentRepository, AuthServices authServices, PortfolioRepository portfolioRepository) {
        this.investmentRepository = investmentRepository;
        this.authServices = authServices;
        this.portfolioRepository = portfolioRepository;
    }

    public void buy(Long id, InvestmentRequest investmentRequest){
        InvestmentTransaction investmentTransaction = new InvestmentTransaction();
        investmentTransaction.setTransactionDate(LocalDateTime.now());
        investmentTransaction.setTransactionType(TransactionType.BUY);
        investmentTransaction.setShares(investmentRequest.shares());
        investmentTransaction.setPricePerShare(investmentRequest.pricePerShares());
        investmentTransaction.setStockSymbol(investmentRequest.stockSymbol());
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        if (portfolio.isPresent()) {
            investmentTransaction.setPortfolio(portfolio.get());
            InvestmentTransaction savedInvestment = investmentRepository.save(investmentTransaction);
            Portfolio portfolioObject = portfolio.get();
            portfolioObject.getTransaction().add(savedInvestment);
            portfolioRepository.save(portfolioObject);
        }else{ throw new IllegalStateException("Binding Portfolio not found");}
    }
}
