package com.guivicj.pokemon_2.mappers;

import com.guivicj.pokemon_2.dtos.CardDTO;
import com.guivicj.pokemon_2.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card toEntity(CardDTO cardDTO);
    CardDTO toDTO(Card card);
}
