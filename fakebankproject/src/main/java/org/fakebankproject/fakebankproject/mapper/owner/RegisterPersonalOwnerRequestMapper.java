package org.fakebankproject.fakebankproject.mapper.owner;

import org.fakebankproject.fakebankproject.dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterPersonalOwnerRequestMapper {
    @Mapping(target = "password", ignore = true)
    PersonalOwner toEntity(RegisterPersonalOwnerRequest registerPersonalOwnerRequest);

    @Mapping(target = "password", ignore = true)
    RegisterPersonalOwnerRequest toDto(PersonalOwner savedOwner);

}
