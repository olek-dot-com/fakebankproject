package org.fakebankproject.fakebankproject.controller;


import org.fakebankproject.fakebankproject.dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fakebankproject.fakebankproject.mapper.owner.RegisterPersonalOwnerRequestMapper;
import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.fakebankproject.fakebankproject.service.PersonalOwnerService;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final PersonalOwnerService personalOwnerService;
    private final RegisterPersonalOwnerRequestMapper registerPersonalOwnerRequestMapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterPersonalOwnerRequest registerPersonalOwner(@Valid @RequestBody RegisterPersonalOwnerRequest dto) {
        PersonalOwner savedOwner = personalOwnerService.registerPersonalOwner(dto);
        return registerPersonalOwnerRequestMapper.toDto(savedOwner);
    }
    @GetMapping("/register")
    public PersonalOwner registerPersonalOwner() {
        //return json object informing everything is ok
        return new PersonalOwner();
    }

}
