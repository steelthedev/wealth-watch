package dev.steelthedev.WealthWatch.API.Portfolio.Controller;


import dev.steelthedev.WealthWatch.API.Auth.Services.AuthServices;
import dev.steelthedev.WealthWatch.API.Portfolio.Model.Portfolio;
import dev.steelthedev.WealthWatch.API.Portfolio.Model.PortfolioRequest;
import dev.steelthedev.WealthWatch.API.Portfolio.Services.PortfolioService;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {


    private final PortfolioService portfolioService;
    private final AuthServices authServices;
    public PortfolioController(PortfolioService portfolioService, AuthServices authServices) {

        this.portfolioService = portfolioService;
        this.authServices = authServices;
    }


    @PostMapping("/create")
    @PreAuthorize("USER")
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Portfolio created successfully")
    public void createPortfolio(@RequestBody PortfolioRequest portfolioRequest, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            Portfolio portfolio = new Portfolio();
            portfolio.setName(portfolioRequest.name());
            portfolio.setDescription(portfolioRequest.description());
            if(authServices.getAuthenticatedUser().isPresent()){
                User user = authServices.getAuthenticatedUser().get();
                portfolio.setUser(user);
            }else{
                return;
            }

            portfolioService.create(portfolio);
        }
    }


    @GetMapping("")
    @PreAuthorize("USER")
    public Iterable<Portfolio> getPortfolioAll(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            if(authServices.getAuthenticatedUser().isPresent()) {
                User user = authServices.getAuthenticatedUser().get();
                return portfolioService.getUserPortfolios((user));
            }
        }return null;
    }

}
