package com.guivicj.pokemon_2.services;

import com.guivicj.pokemon_2.dtos.CardDTO;
import com.guivicj.pokemon_2.mappers.CardMapper;
import com.guivicj.pokemon_2.models.Card;
import com.guivicj.pokemon_2.repositories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public CardDTO saveCard(CardDTO cardDTO) {
        Card card = cardMapper.toEntity(cardDTO);
        Card savedCard = cardRepository.save(card);
        return cardMapper.toDTO(savedCard);
    }

    public List<CardDTO> saveCards(List<CardDTO> cardDTOList) {
        List<Card> cards = cardDTOList.stream()
                .map(cardMapper::toEntity)
                .collect(Collectors.toList());

        List<Card> savedCards = cardRepository.saveAll(cards);
        return savedCards.stream()
                .map(cardMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CardDTO> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(cardMapper::toDTO)
                .toList();
    }

    public Optional<CardDTO> getCardById(Long id) {
        return cardRepository.findById(id).map(cardMapper::toDTO);
    }

    public List<CardDTO> get5RandomCards() {
        List<CardDTO> cardDTOS = new ArrayList<>();
        Random random = new Random();
        List<Card> cards = cardRepository.findAll();
        for (int i = 1; i <= 5; i++) {
            cardDTOS.add(cardMapper.toDTO(cards.get(random.nextInt(cards.size()))));
        }
        return cardDTOS;
    }
}
