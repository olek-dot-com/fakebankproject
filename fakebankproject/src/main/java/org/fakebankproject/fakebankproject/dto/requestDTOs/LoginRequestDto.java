package org.fakebankproject.fakebankproject.dto.requestDTOs;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRequestDto {
    private String login;
    private String password;


}
