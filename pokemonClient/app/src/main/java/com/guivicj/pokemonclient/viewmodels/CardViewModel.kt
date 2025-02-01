package com.guivicj.pokemonclient.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guivicj.pokemonclient.data.models.Card
import com.guivicj.pokemonclient.data.networks.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CardViewModel : ViewModel() {
    private val _cards = MutableStateFlow<List<Card>>(emptyList())
    val cards = _cards.asStateFlow()

    fun fetchPack() {
        viewModelScope.launch {
            try {
                _cards.value = RetrofitInstance.api.getCards()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
