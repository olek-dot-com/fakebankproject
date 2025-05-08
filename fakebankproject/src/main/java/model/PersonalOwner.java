package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Pattern;


@Entity
public class PersonalOwner extends Owner {
    public PersonalOwner() {}

    @Column(nullable = false)
    @Pattern(regexp = "[A-Z][a-z]+", message = "First name must start with a capital letter and contain only letters")
    private String firstName;

    @Column(nullable = false)
    @Pattern(regexp = "[A-Z][a-z]+", message = "Last name must start with a capital letter and contain only letters")
    private String lastName;

    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "Email must be valid")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "\\d{9}", message = "Phone number must be 9 digits")
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Pattern(regexp = "[A-Z][a-z]+", message = "City name must start with a capital letter and contain only letters")
    private String city;

    @Column(nullable = false)
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must be in the format XX-XXX")
    private String postalCode;

    @Column(nullable = false)
    @Pattern(regexp = "[A-Z][a-zA-Z ]+", message = "Country name must start with a capital letter and contain only letters and spaces")
    private String country;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "\\d{11}", message = "PESEL must be 10 digits")
    private String PESEL;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
}
