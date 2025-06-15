package org.fakebankproject.fakebankproject.service;


import org.fakebankproject.fakebankproject.dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import lombok.RequiredArgsConstructor;
import org.fakebankproject.fakebankproject.mapper.owner.RegisterPersonalOwnerRequestMapper;
import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.fakebankproject.fakebankproject.repository.PersonalOwnerRepository;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class PersonalOwnerService {

    private final PersonalOwnerRepository personalOwnerRepository;
    private final RegisterPersonalOwnerRequestMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public PersonalOwner registerPersonalOwner(RegisterPersonalOwnerRequest dto) {
        PersonalOwner personalOwner = mapper.toEntity(dto);
        personalOwner.setPassword(passwordEncoder.encode(dto.getPassword()));

        String login;
        do{
            login = generateLogin();
        }while(personalOwnerRepository.existsByLogin(login));
        personalOwner.setLogin(login);
        return personalOwnerRepository.save(personalOwner);
    }

    /**
    generates nine digits login
     */
    private String generateLogin() {
        Random random = new Random();
        StringBuilder login = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            login.append(random.nextInt(10));
        }
        return login.toString();
    }
}
