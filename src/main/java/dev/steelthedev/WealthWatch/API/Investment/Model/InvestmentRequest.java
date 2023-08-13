package dev.steelthedev.WealthWatch.API.Investment.Model;


public record InvestmentRequest(

        String stockSymbol,
        Integer shares,
        double pricePerShares
) {
}