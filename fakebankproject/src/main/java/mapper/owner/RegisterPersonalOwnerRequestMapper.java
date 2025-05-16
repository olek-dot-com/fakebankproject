package mapper.owner;

import dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import model.PersonalOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterPersonalOwnerRequestMapper {
    @Mapping(target = "password", ignore = true)
    PersonalOwner toEntity(RegisterPersonalOwnerRequest registerPersonalOwnerRequest);
    //RegisterPersonalOwnerRequest toDTO(PersonalOwner personalOwner);
}
