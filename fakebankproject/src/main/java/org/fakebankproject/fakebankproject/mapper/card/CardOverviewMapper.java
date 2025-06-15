package org.fakebankproject.fakebankproject.mapper.card;


import org.fakebankproject.fakebankproject.dto.responseDTOs.card.CardDTO;
import org.fakebankproject.fakebankproject.model.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardOverviewMapper {
    CardDTO toDTO(Card card);
    Card toEntity(CardDTO cardDTO);
}
