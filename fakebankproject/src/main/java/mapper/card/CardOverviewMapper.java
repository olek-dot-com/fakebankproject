package mapper.card;


import dto.responseDTOs.card.CardDTO;
import model.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardOverviewMapper {
    CardDTO toDTO(Card card);
    Card toEntity(CardDTO cardDTO);
}
