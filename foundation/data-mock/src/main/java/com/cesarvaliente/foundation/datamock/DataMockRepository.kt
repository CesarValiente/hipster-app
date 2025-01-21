package com.cesarvaliente.foundation.datamock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataMockRepository {
    fun getSuperHeroesList() : Flow<List<SuperHero>> = flow {
        val superHeroList = listOf(
            SuperHero(
                name = "Tony Stark",
                superName = "IronMan",
                age = "45",
                imageUri = R.raw.ironman
            ),
            SuperHero(
                name = "Bruce Wayne",
                superName = "Batman",
                age = "35",
                imageUri = R.raw.batman
            ),
            SuperHero(
                name = "Clark Kent",
                superName = "Superman",
                age = "40",
                imageUri = R.raw.superman
            ), SuperHero(
                name = "Diana Prince",
                superName = "Wonder Woman",
                age = "30",
                imageUri = R.raw.wonderwoman
            ), SuperHero(
                name = "Peter Parker",
                superName = "Spiderman",
                age = "25",
                imageUri = R.raw.spiderman
            ), SuperHero(
                name = "Bruce Banner",
                superName = "Hulk",
                age = "35",
                imageUri = R.raw.hulk
            ), SuperHero(
                name = "Steve Rogers",
                superName = "Captain America",
                age = "40",
                imageUri = R.raw.captainamerica
            ), SuperHero(
                name = "Thor Odinson",
                superName = "Thor",
                age = "35",
                imageUri = R.raw.thor
            ), SuperHero(
                name = "Wade Wilson",
                superName = "Deadpool",
                age = "30",
                imageUri = R.raw.deadpool
            ), SuperHero(
                name = "Scott Lang",
                superName = "Antman",
                age = "35",
                imageUri = R.raw.antman
            ), SuperHero(
                name = "Natasha Romanoff",
                superName = "Black Widow",
                age = "35",
                imageUri = R.raw.blackwidow
            ), SuperHero(
                name = "Carol Danvers",
                superName = "Captain Marvel",
                age = "30",
                imageUri = R.raw.captainmarvel
            ), SuperHero(
                name = "T'Challa",
                superName = "Black Panther",
                age = "35",
                imageUri = R.raw.blackpanther
            ), SuperHero(
                name = "Matt Murdock",
                superName = "Daredevil",
                age = "35",
                imageUri = R.raw.daredevil
            ), SuperHero(
                name = "Jessica Jones",
                superName = "Jessica Jones",
                age = "35",
                imageUri = R.raw.jessicajones
            ), SuperHero(
                name = "Luke Cage",
                superName = "Luke Cage",
                age = "35",
                imageUri = R.raw.lukecage
            ), SuperHero(
                name = "Danny Rand",
                superName = "Iron Fist",
                age = "35",
                imageUri = R.raw.ironfist
            ), SuperHero(
                name = "Frank Castle",
                superName = "Punisher",
                age = "35",
                imageUri = R.raw.punisher
            ), SuperHero(
                name = "Stephen Strange",
                superName = "Doctor Strange",
                age = "35",
                imageUri = R.raw.doctorstrange
            ), SuperHero(
                name = "Wanda Maximoff",
                superName = "Scarlet Witch",
                age = "35",
                imageUri = R.raw.scarletwitch
            ), SuperHero(
                name = "Vision",
                superName = "Vision",
                age = "35",
                imageUri = R.raw.vision
            ), SuperHero(
                name = "Sam Wilson",
                superName = "Falcon",
                age = "35",
                imageUri = R.raw.falcon
            ), SuperHero(
                name = "Bucky Barnes",
                superName = "Winter Soldier",
                age = "35",
                imageUri = R.raw.wintersoldier
            )
        )
        emit(superHeroList)
    }
}