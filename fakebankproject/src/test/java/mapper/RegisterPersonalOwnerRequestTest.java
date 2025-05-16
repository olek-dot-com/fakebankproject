package mapper;

import dto.requestDTOs.owner.RegisterPersonalOwnerRequest;
import mapper.owner.RegisterPersonalOwnerRequestMapper;
import model.PersonalOwner;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterPersonalOwnerRequestTest {

    private final RegisterPersonalOwnerRequestMapper mapper = Mappers.getMapper(RegisterPersonalOwnerRequestMapper.class);

    // Test if the mapper correctly maps the DTO to the entity
    @Test
    void shouldMapDtoToEntity() {

        RegisterPersonalOwnerRequest dto = RegisterPersonalOwnerRequest.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("jan@example.com")
                .phoneNumber("123456789")
                .address("Testowa 1")
                .city("Warszawa")
                .postalCode("00-001")
                .country("Polska")
                .dateOfBirth(java.time.LocalDate.of(1990, 1, 1))
                .pesel("90010112345")
                //TODO: add password and compare it with its hash
                .build();

        PersonalOwner entity = mapper.toEntity(dto);

        // then
        assertEquals(dto.getFirstName(), entity.getFirstName());
        assertEquals(dto.getLastName(), entity.getLastName());
        assertEquals(dto.getEmail(), entity.getEmail());
        assertEquals(dto.getPhoneNumber(), entity.getPhoneNumber());
        assertEquals(dto.getAddress(), entity.getAddress());
        assertEquals(dto.getCity(), entity.getCity());
        assertEquals(dto.getPostalCode(), entity.getPostalCode());
        assertEquals(dto.getCountry(), entity.getCountry());
        assertEquals(dto.getPesel(), entity.getPesel());
    }
}