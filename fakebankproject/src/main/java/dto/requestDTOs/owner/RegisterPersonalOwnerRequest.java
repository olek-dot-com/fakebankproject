
package dto.requestDTOs.owner;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO wykorzystywane podczas rejestracji właściciela prywatnego.
 * Wszystkie pola są walidowane zanim trafią do serwisu.
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterPersonalOwnerRequest {

    @NotBlank(message = "First name is required")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M}]+(?:[ '\\-][\\p{L}\\p{M}]+)*",
            message = "First name must start with a capital letter and contain only letters"
    )
    private String firstName;


    @NotBlank(message = "Last name is required")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M}]+(?:[ '\\-][\\p{L}\\p{M}]+)*",
            message = "Last name must start with a capital letter and contain only letters"
    )
    private String lastName;


    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email address")
    private String email;


    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{9}", message = "Phone number must be exactly 9 digits")
    private String phoneNumber;


    @NotBlank(message = "Address is required")
    @Size(min = 2, max = 60, message = "Address must be between 2 and 60 characters")
    private String address;

    @NotBlank(message = "City is required")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M} ]+",
            message = "City must start with a capital letter and contain only letters/spaces"
    )
    @Size(min = 2, max = 60, message = "City must be between 2 and 60 characters")
    private String city;


    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must follow format XX-XXX")
    private String postalCode;


    @NotBlank(message = "Country is required")
    @Pattern(
            regexp = "\\p{Lu}[\\p{L}\\p{M} ]+",
            message = "Country must start with a capital letter and contain only letters/spaces"
    )
    private String country;


    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotBlank(message = "PESEL is required")
    @Pattern(regexp = "\\d{11}", message = "PESEL must be exactly 11 digits")
    private String pesel;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;


}
