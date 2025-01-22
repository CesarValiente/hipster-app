package com.cesarvaliente.marvelapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarvaliente.foundation.datamock.DataMockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class SuperHeroUiState(
    val name : String,
    val superName : String,
    val age : String,
    val imageUri : Int
)

data class SuperHeroListUiState(
    val superHeroesList: List<SuperHeroUiState> = emptyList()
)

class MarvelViewModel : ViewModel() {
    private val repository = DataMockRepository()

    // This is the state that will be observed by the UI
    private val _uiState = MutableStateFlow(SuperHeroListUiState())
    val uiState : StateFlow<SuperHeroListUiState> = _uiState

    init {
        getSuperHeroList()
    }
    // Handle business logic
    fun getSuperHeroList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.d("MarvelThread", "Running on thread: ${Thread.currentThread().name}")
                repository.getSuperHeroesList().collect() { superHeroesList ->
                    val superHeroesListUiState = superHeroesList.toUiStateList()
                    withContext(Dispatchers.Main) {
                        Log.d("MarvelThread", "Running on thread: ${Thread.currentThread().name}")
                        _uiState.update { it.copy(superHeroesList = superHeroesListUiState) }
                    }
                }
            }
        }
    }
}
