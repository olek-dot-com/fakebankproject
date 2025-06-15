package org.fakebankproject.fakebankproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BusinessOwner extends Owner{

    @Column(nullable = false, unique = true, name = "CompanyName")
    private String companyName;

    @Pattern(regexp = "\\d{10}", message = "NIP must be 10 digits")
    @Column(nullable = false, name = "taxID")
    private String taxID;

}
