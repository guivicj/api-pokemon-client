package com.guivicj.pokemonclient.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.guivicj.pokemonclient.data.models.Card

@Composable
fun CardItem(card: Card) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(card.imageUrl),
            contentDescription = card.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(150.dp).fillMaxWidth()
        )
        Text(text = card.name)
        Text(text = "Tipo: ${card.type}")
        Text(text = "Rareza: ${card.rarity}")
        Spacer(modifier = Modifier.height(8.dp))
    }
}
