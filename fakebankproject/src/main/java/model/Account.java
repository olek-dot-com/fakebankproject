package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountNumber", unique = true, nullable = false)
    private String accountNumber;

    private LocalDate createdDate;

    private LocalDate freezedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(name = "dailyLimit")
    private BigDecimal dailyLimit;

    @Column(name = "interestRate")
    private BigDecimal interestRate;


}
