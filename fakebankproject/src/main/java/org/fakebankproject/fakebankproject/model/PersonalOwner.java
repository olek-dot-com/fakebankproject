package org.fakebankproject.fakebankproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Encja reprezentująca właściciela prywatnego.
 * Zawiera podstawowe pola, walidowane zarówno przez Bean Validation,
 * jak i przez ograniczenia JPA, dla zapewnienia integralności danych.
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonalOwner extends Owner {

    /**
     * Imię właściciela.
     * \p{Lu} – dowolna wielka litera Unicode,
     * [\p{L}\p{M}]+ – litery Unicode (+ łączące znaki akcentujące),
     * (?:[ '-][\p{L}\p{M}]+)* – opcjonalne części imienia z odstępami, apostrofami, myślnikiem.
     */
    @NotBlank(message = "First name cannot be blank")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M}]+(?:[ '\\-][\\p{L}\\p{M}]+)*",
            message = "First name must start with a capital letter and contain only letters"
    )
    @Column(name = "firstName", nullable = false, length = 60)
    private String firstName;

    /**
     * Nazwisko właściciela.
     * Zasada identyczna jak dla firstName.
     */
    @NotBlank(message = "Last name cannot be blank")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M}]+(?:[ '\\-][\\p{L}\\p{M}]+)*",
            message = "Last name must start with a capital letter and contain only letters"
    )
    @Column(name = "lastName", nullable = false, length = 60)
    private String lastName;


    @NotNull(message = "Birth date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dateOfBirth;


    /**
     * Numer PESEL – dokładnie 11 cyfr.
     */
    @NotBlank(message = "PESEL cannot be blank")
    @Pattern(regexp = "\\d{11}", message = "PESEL must be exactly 11 digits")
    @Column(name = "pesel", nullable = false, unique = true, length = 11)
    private String pesel;

}
