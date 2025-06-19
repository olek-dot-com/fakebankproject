package org.fakebankproject.fakebankproject.dto.responseDTOs;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private String login;
    private String firstName;
    private String lastName;
    private String token;
}
