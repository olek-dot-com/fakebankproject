package org.fakebankproject.fakebankproject.controller;


import org.fakebankproject.fakebankproject.config.JwtUtil;
import org.fakebankproject.fakebankproject.dto.requestDTOs.LoginRequestDto;
import org.fakebankproject.fakebankproject.dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fakebankproject.fakebankproject.dto.responseDTOs.LoginResponse;
import org.fakebankproject.fakebankproject.mapper.owner.RegisterPersonalOwnerRequestMapper;
import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.fakebankproject.fakebankproject.service.PersonalOwnerLoginService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.fakebankproject.fakebankproject.service.PersonalOwnerRegistrationService;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final PersonalOwnerRegistrationService personalOwnerRegistrationService;
    private final RegisterPersonalOwnerRequestMapper registerPersonalOwnerRequestMapper;

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final PersonalOwnerLoginService profileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterPersonalOwnerRequest registerPersonalOwner(@Valid @RequestBody RegisterPersonalOwnerRequest dto) {
        PersonalOwner savedOwner = personalOwnerRegistrationService.registerPersonalOwner(dto);
        return registerPersonalOwnerRequestMapper.toDto(savedOwner);
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse loginPersonalOwner(@Valid @RequestBody LoginRequestDto dto){
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword())
        );
        String token = jwtUtil.generateToken((UserDetails) auth.getPrincipal());
        PersonalOwner owner = profileService.getByLogin(dto.getLogin());
        return new LoginResponse(
                owner.getLogin(),
                owner.getFirstName(),
                owner.getLastName(),
                token
        );
    }

}
