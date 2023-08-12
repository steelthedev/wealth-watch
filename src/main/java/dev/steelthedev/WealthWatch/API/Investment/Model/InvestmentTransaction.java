package dev.steelthedev.WealthWatch.API.Investment.Model;

import dev.steelthedev.WealthWatch.API.Portfolio.Model.Portfolio;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class InvestmentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private LocalDateTime transactionDate;
    private String stockSymbol;
    private int shares;
    private double pricePerShare;
    @ManyToOne
    private Portfolio portfolio;


    public InvestmentTransaction() {}
    public InvestmentTransaction(TransactionType transactionType, LocalDateTime transactionDate, String stockSymbol, int shares, double pricePerShare, Portfolio portfolio) {
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.stockSymbol = stockSymbol;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
        this.portfolio = portfolio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", transactionType=" + transactionType +
                ", transactionDate=" + transactionDate +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", shares=" + shares +
                ", pricePerShare=" + pricePerShare +
                ", portfolio=" + portfolio +
                '}';
    }
}
