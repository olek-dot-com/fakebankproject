package org.fakebankproject.fakebankproject.mapper.owner;

import org.fakebankproject.fakebankproject.dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import org.fakebankproject.fakebankproject.model.PersonalOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterPersonalOwnerResponseMapper {
    @Mapping(target = "password", ignore = true)
    PersonalOwner toDto(RegisterPersonalOwnerRequest registerPersonalOwnerRequest);
}
