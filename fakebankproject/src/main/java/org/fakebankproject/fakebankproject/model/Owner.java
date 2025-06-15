package org.fakebankproject.fakebankproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

/**
 * Abstrakcyjna encja reprezentująca wspólne właściwości wszystkich właścicieli.
 * Korzysta z SINGLE_TABLE inheritance i rozróżnia typy encji przez kolumnę ownerType.
 */
@Entity
@Table(name = "owners")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ownerType", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Owner {

    /**
     * Adres e-mail właściciela.
     */
    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email address")
    @Column(nullable = false, length = 100)
    private String email;

    /**
     * Unikalny identyfikator UUID generowany przez Hibernate.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    /**
     * Lista kont powiązanych z właścicielem.
     */
    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Account> accounts;

    /**
     * Numer telefonu – dokładnie 9 cyfr.
     */
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{9}", message = "Phone number must be exactly 9 digits")
    @Column(name = "phone_number", nullable = false, length = 9)
    private String phoneNumber;

    /**
     * Adres zamieszkania – od 2 do 60 znaków.
     */
    @NotBlank(message = "Address is required")
    @Size(min = 2, max = 60, message = "Address must be between 2 and 60 characters")
    @Column(nullable = false, length = 60)
    private String address;

    /**
     * Miasto – Unicode letters/spaces, 2–60 znaków.
     */
    @NotBlank(message = "City is required")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M} ]{1,59}",
            message = "City must start with a capital letter and contain only letters/spaces"
    )
    @Column(nullable = false, length = 60)
    private String city;

    /**
     * Kod pocztowy – format XX-XXX.
     */
    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must follow format XX-XXX")
    @Column(name = "postal_code", nullable = false, length = 6)
    private String postalCode;

    /**
     * Kraj – Unicode letters/spaces, 2–60 znaków.
     */
    @NotBlank(message = "Country is required")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M} ]{1,59}",
            message = "Country must start with a capital letter and contain only letters/spaces"
    )
    @Column(nullable = false, length = 60)
    private String country;

    @NotBlank
    private String password;

    @NotBlank
    @Column(name = "login", unique = true, length = 9)
    private String login;
}
