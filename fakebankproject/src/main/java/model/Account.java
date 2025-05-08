package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountNumber", unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private LocalDate createdDate;

    private LocalDate frozenDate = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    /**
     * Account balance in the default currency (PLN)
     */
    @Column(name = "balance")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "defaultCurrency")
    private Currency defaultCurrency = Currency.PLN;

    @Enumerated(EnumType.STRING)
    //implement default value after start to ACTIVE status from enum class
    @Column(nullable = false)
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(name = "dailyLimit")
    private BigDecimal dailyLimit;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurrencyBalance> currencyBalances;


}
