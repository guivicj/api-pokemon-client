package com.guivicj.pokemon_2.repositories;

import com.guivicj.pokemon_2.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
