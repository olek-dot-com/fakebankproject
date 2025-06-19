package org.fakebankproject.fakebankproject.repository;

import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonalOwnerRepository extends JpaRepository<PersonalOwner, UUID> {
//    boolean existsByEmail(String email);
//    boolean existsByPesel(String pesel);
//    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByLogin(String login);
    Optional<PersonalOwner> findByLogin(String login);




}
