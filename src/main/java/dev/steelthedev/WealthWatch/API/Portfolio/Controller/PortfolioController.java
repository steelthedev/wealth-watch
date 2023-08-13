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

import java.util.Optional;

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
    @PreAuthorize("hasAuthority('USER')")
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
    @PreAuthorize("hasAuthority('USER')")
    public Iterable<Portfolio> getPortfolioAll(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            if(authServices.getAuthenticatedUser().isPresent()) {
                User user = authServices.getAuthenticatedUser().get();
                return portfolioService.getUserPortfolios((user));
            }
        }return null;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Portfolio> getPortfolio(@PathVariable Long id){
        return portfolioService.getPortfolio(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('USER')")
    @ResponseStatus(value = HttpStatus.OK,reason = "Deleted successfullly")
    public void deletePortfolio(@PathVariable Long id){
        portfolioService.deletePorfolio(id);
    }


    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('USER')")
    @ResponseStatus(value = HttpStatus.OK,reason = "Edited successfullly")
    public void editPortfolio(@PathVariable Long id, @RequestBody PortfolioRequest portfolioRequest){
        portfolioService.editPorfolio(id,portfolioRequest);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Iterable<Portfolio> listAll(){
        return portfolioService.getAll();
    }



}
