package model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cards")
public class Card {
    public Card() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cardNumber;
    private String expirationDate;
    private String cvv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
}
