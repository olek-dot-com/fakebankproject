package org.fakebankproject.fakebankproject.dto.responseDTOs.owner;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessOwnerOverviewResponse {

    @NotBlank(message = "Compant name is required")
    private String companyName;

    @NotBlank(message = "Tax ID is required")
    private String taxId;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern
            (
            regexp = "\\d{9}",
            message = "Phone number must be exactly 9 digits"
    )
    private String phoneNumber;
}
