package com.example.retrofitdemoweek5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitdemoweek5.ui.theme.RetrofitDemoWeek5Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitDemoWeek5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 🔄 Replace Greeting() with NetworkCallExample()
                    NetworkCallExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NetworkCallExample(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        try {
            val post = withContext(Dispatchers.IO) {
                RetrofitInstance.api.getPost()
            }
            result = post.title
        } catch (e: Exception) {
            result = "Error: ${e.message}"
        }
    }

    Text(
        text = result,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun NetworkCallExamplePreview() {
    RetrofitDemoWeek5Theme {
        NetworkCallExample()
    }
}