package org.fakebankproject.fakebankproject.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;


    @Column(name = "accountNumber", unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private LocalDate createdDate;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    private LocalDate frozenDate = null;
    /**
     * Account balance in the default currency (PLN)
     */

    @Column(name = "balance")
    private BigDecimal balance;


    @Enumerated(EnumType.STRING)
    @Column(name = "defaultCurrency")
    private Currency defaultCurrency = Currency.PLN;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;


    @Column(name = "dailyLimit")
    private BigDecimal dailyLimit;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurrencyBalance> currencyBalances;



}
