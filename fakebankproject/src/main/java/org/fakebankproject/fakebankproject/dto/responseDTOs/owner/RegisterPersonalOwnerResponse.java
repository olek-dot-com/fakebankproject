package org.fakebankproject.fakebankproject.dto.responseDTOs.owner;
import lombok.AllArgsConstructor;

import org.fakebankproject.fakebankproject.model.Currency;
import java.util.UUID;

@AllArgsConstructor
public class RegisterPersonalOwnerResponse {
    private String email;
    private UUID uuid;
    private Currency currency;
//TODO design a mail service and send login by email
}
