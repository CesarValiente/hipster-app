package com.cesarvaliente.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.cesarvaliente.myapplication.ui.theme.BasicCodelabTheme

class MarvelListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}