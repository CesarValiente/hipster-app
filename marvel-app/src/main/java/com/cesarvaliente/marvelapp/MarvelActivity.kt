package com.cesarvaliente.marvelapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cesarvaliente.marvelapp.ui.theme.MarvelAppTheme
import com.cesarvaliente.foundation.datamock.R as DataR

class MarvelActivity : ComponentActivity() {
    private val viewModel : MarvelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MarvelThread", "Running on thread: ${Thread.currentThread().name}")
        setContent {
            MarvelAppTheme {
                val uiState by viewModel.uiState.collectAsState()
                SuperHeroesList(heroesList = uiState.superHeroesList)
            }
        }
    }
}

@Composable
fun SuperHeroesList(
    modifier: Modifier = Modifier,
    heroesList : List<SuperHeroUiState>
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = heroesList) { superHero ->
            SuperHeroCard (
                modifier,
                superHero)
        }
    }
}

@Preview
@Composable
fun SuperHeroesListPreview() {
    SuperHeroesList(
        heroesList = listOf(
            SuperHeroUiState("Tony Stark", "IronMan", "45", 0),
            SuperHeroUiState("Steve Rogers", "Captain America", "100", 0)
        )
    )
}

@Composable
fun SuperHeroCard(
    modifier: Modifier = Modifier,
    superHero: SuperHeroUiState
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ){
        CardContent(superHero)
    }
}

@Preview
@Composable
fun SuperHeroCardPreview() {
    MarvelAppTheme {
        SuperHeroCard(superHero = SuperHeroUiState(
            name = "Tony Stark",
            superName = "IronMan",
            age = "45",
            imageUri = DataR.raw.ironman)
        )
    }
}

@Composable
fun CardContent(superHero: SuperHeroUiState) {
    Row(modifier = Modifier.fillMaxSize()
        .padding(all = 8.dp)
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    ){
        Image(
            painter = painterResource(id = superHero.imageUri),
            contentDescription = "super hero profile picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = superHero.name,
                style = MaterialTheme.typography.titleLarge)
            Text(
                text = superHero.superName,
                style = MaterialTheme.typography.bodyMedium)
            Text(text = superHero.age)
        }
    }
}
