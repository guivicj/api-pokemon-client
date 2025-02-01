package com.guivicj.pokemonclient.data.models

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("rarity") val rarity: String,
    @SerializedName("imageUrl") val imageUrl: String
)
