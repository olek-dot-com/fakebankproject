package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessOwnerDTO {
    private String companyName;
    private String taxId;
    private String email;
    private String phoneNumber;
}
