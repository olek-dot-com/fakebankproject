package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "account_balances",
        uniqueConstraints = @UniqueConstraint(columnNames = {"account_id","currency"}))
@Getter
@Setter
public class CurrencyBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency currency;


    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public CurrencyBalance() {}

    public CurrencyBalance(Currency currency, BigDecimal amount, Account account) {
        this.currency = currency;
        this.amount = amount;
        this.account = account;
    }
}
