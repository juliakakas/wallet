package hu.progmatic.wallet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Expense {

    @Id
    private Long id;

    private Integer balance;
    private Integer payoff;

    @OneToMany(mappedBy = "expense")
    @JsonBackReference
    private List<Wallet> wallets = new ArrayList<>();

    public Expense(Integer balance, Integer payoff){
        this.balance = balance;
        this.payoff = payoff;
    }

    public Expense(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getPayoff() {
        return payoff;
    }

    public void setPayoff(Integer payoff) {
        this.payoff = payoff;
    }


}
