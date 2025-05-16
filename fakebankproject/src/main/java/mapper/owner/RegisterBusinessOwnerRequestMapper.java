package mapper.owner;


import dto.requestDTOs.owner.RegisterBusinessOwnerRequest;
import model.BusinessOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterBusinessOwnerRequestMapper {
    BusinessOwner toEntity(RegisterBusinessOwnerRequest request);
    RegisterBusinessOwnerRequest toDTO(BusinessOwner businessOwner);
}
