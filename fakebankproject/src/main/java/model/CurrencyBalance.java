package model;

import jakarta.persistence.*;

@Entity
@Table(name = "account_balances",
        uniqueConstraints = @UniqueConstraint(columnNames = {"account_id","currency"}))
public class CurrencyBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Waluta (PLN, EUR, USD...)
    private String currency;

    // Suma środków w danej walucie
    private double amount;

    // Powiązanie do konta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public CurrencyBalance() {}

    public CurrencyBalance(String currency, double amount, Account account) {
        this.currency = currency;
        this.amount = amount;
        this.account = account;
    }
}
