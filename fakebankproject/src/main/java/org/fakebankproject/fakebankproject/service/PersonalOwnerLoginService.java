package org.fakebankproject.fakebankproject.service;

import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.fakebankproject.fakebankproject.repository.PersonalOwnerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class PersonalOwnerLoginService implements UserDetailsService {
    private final PersonalOwnerRepository personalOwnerRepository;

    public PersonalOwnerLoginService(PersonalOwnerRepository personalOwnerRepository) {
        this.personalOwnerRepository = personalOwnerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonalOwner owner = personalOwnerRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return User.builder()
                .username(owner.getLogin())
                .password(owner.getPassword())
                .build();
    }

    public PersonalOwner getByLogin(String login) {
        return personalOwnerRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));
    }
}
