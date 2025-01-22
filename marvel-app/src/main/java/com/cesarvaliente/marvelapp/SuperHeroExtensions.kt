package com.cesarvaliente.marvelapp

import com.cesarvaliente.foundation.datamock.SuperHero

fun SuperHero.toUiState(): SuperHeroUiState {
    return SuperHeroUiState(
        name = this.name,
        superName = this.superName,
        age = this.age,
        imageUri = this.imageUri
    )
}

fun List<SuperHero>.toUiStateList(): List<SuperHeroUiState> {
    return this.map { it.toUiState() }
}