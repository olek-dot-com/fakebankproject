package org.fakebankproject.fakebankproject.mapper.owner;

import org.fakebankproject.fakebankproject.dto.responseDTOs.owner.BusinessOwnerOverviewResponse;
import org.fakebankproject.fakebankproject.model.BusinessOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessOwnerOverviewMapper {
    BusinessOwnerOverviewResponse toDTO(BusinessOwner businessOwner);
    BusinessOwner toEntity(BusinessOwnerOverviewResponse businessOwnerDTO);
}
