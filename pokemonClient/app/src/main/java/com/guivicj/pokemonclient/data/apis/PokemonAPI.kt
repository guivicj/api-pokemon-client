package com.guivicj.pokemonclient.data.apis

import com.guivicj.pokemonclient.data.models.Card
import retrofit2.http.GET


interface PokemonAPI {
    @GET("api/cards/pack")
    suspend fun getCards(): List<Card>
}