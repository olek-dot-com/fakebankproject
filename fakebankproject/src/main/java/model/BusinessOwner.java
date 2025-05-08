package model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessOwner extends Owner{

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyAddress;

    @Column(nullable = false)
    private String companyCity;

    @Column(nullable = false)
    private String companyPostalCode;

    @Column(nullable = false)
    private String companyCountry;

    @Column(nullable = false)
    private String companyPhoneNumber;

    @Column(nullable = false)
    private String companyEmail;




    @Pattern(regexp = "\\d{11}", message = "NIP must be 10 digits")
    @Column(nullable = false)
    private String taxID;


}
