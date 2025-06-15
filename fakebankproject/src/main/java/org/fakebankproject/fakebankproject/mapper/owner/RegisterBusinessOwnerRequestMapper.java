package org.fakebankproject.fakebankproject.mapper.owner;


import org.fakebankproject.fakebankproject.dto.requestDTOs.owner.RegisterBusinessOwnerRequest;
import org.fakebankproject.fakebankproject.model.BusinessOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterBusinessOwnerRequestMapper {
    BusinessOwner toEntity(RegisterBusinessOwnerRequest request);
    RegisterBusinessOwnerRequest toDTO(BusinessOwner businessOwner);
}
