package dev.steelthedev.WealthWatch.API.Portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.steelthedev.WealthWatch.API.Investment.Model.InvestmentTransaction;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.function.Consumer;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("portfolio")
    private List<InvestmentTransaction> transaction;

    public Portfolio(){}

    public Portfolio(String name, String description, User user, List<InvestmentTransaction> transaction) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.transaction = transaction;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<InvestmentTransaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<InvestmentTransaction> transaction) {
        this.transaction = transaction;
    }
}
