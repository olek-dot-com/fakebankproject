package mapper.owner;

import dto.responseDTOs.owner.BusinessOwnerOverviewResponse;
import model.BusinessOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessOwnerOverviewMapper {
    BusinessOwnerOverviewResponse toDTO(BusinessOwner businessOwner);
    BusinessOwner toEntity(BusinessOwnerOverviewResponse businessOwnerDTO);
}
