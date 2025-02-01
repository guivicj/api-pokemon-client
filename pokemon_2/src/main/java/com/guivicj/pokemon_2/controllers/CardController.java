package com.guivicj.pokemon_2.controllers;

import com.guivicj.pokemon_2.dtos.CardDTO;
import com.guivicj.pokemon_2.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable Long id) {
        Optional<CardDTO> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/pack")
    public ResponseEntity<List<CardDTO>> get5RandomCards() {
        return ResponseEntity.ok(cardService.get5RandomCards());
    }

    @PostMapping
    public ResponseEntity<CardDTO> saveCard(@RequestBody CardDTO cardDTO) {
        return ResponseEntity.ok(cardService.saveCard(cardDTO));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<CardDTO>> saveCards(@RequestBody List<CardDTO> cardDTOList) {
        return ResponseEntity.ok(cardService.saveCards(cardDTOList));
    }


}
