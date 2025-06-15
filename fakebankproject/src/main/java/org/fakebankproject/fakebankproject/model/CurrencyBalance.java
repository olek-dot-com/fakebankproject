package org.fakebankproject.fakebankproject.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "currency_balances",
        uniqueConstraints = @UniqueConstraint(columnNames = {"account_id","currency"}))
@Getter
@Setter
public class CurrencyBalance {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Currency currency;


    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public CurrencyBalance() {}


}
