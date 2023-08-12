package dev.steelthedev.WealthWatch.API.Investment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class StockMarketData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stockSymbol;
    private LocalDate date;
    private double openingPrice;
    private double closingPrice;
    private long volume;

    public StockMarketData(){}
    public StockMarketData(String stockSymbol, LocalDate date, double openingPrice, double closingPrice, long volume) {
        this.stockSymbol = stockSymbol;
        this.date = date;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
        this.volume = volume;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "StockMarketData{" +
                "id=" + id +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", date=" + date +
                ", openingPrice=" + openingPrice +
                ", closingPrice=" + closingPrice +
                ", volume=" + volume +
                '}';
    }
}
