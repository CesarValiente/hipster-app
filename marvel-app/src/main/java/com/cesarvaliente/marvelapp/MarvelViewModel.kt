package com.cesarvaliente.marvelapp

import androidx.lifecycle.ViewModel
import com.cesarvaliente.foundation.datamock.DataMockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class SuperHeroUiState(
    val name : String,
    val superName : String,
    val age : String,
    val imageUri : Int
) {
    companion object {
        val Empty = SuperHeroUiState("", "", "", 0)
    }
}

data class SuperHeroListUiState(
    val superHeroesList: List<SuperHeroUiState> = emptyList()
)

class MarvelViewModel : ViewModel() {
    private val repository = DataMockRepository()

    // This is the state that will be observed by the UI
    private val _uiState = MutableStateFlow(SuperHeroListUiState())
    val uiState : StateFlow<SuperHeroListUiState> = _uiState

    // Handle business logic
    fun getSuperHeroList() {
        val superHeroes = repository.getSuperHeroesList()
        val superHeroesListUiState = superHeroes.toUiStateList()
        _uiState.update { uiState -> uiState.copy(superHeroesList = superHeroesListUiState) }
    }
}
