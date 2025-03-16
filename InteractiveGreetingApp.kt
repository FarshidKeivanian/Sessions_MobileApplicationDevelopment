package com.example.interactivegreeting  // Ensure package matches the file location

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interactivegreeting.ui.theme.HelloAppTheme  // Ensure this import is correct

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloAppTheme { // Ensure this theme exists
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InteractiveGreeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InteractiveGreeting(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var greetingMessage by remember { mutableStateOf("Hello, Farshid!") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                greetingMessage = if (name.isNotBlank()) "Hello, $name!" else "Hello, Farshid!"
            }),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                greetingMessage = if (name.isNotBlank()) "Hello, $name!" else "Hello, Farshid!"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Greet Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = greetingMessage,
            style = MaterialTheme.typography.bodyLarge,  // <--- Fixed possible issue
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloAppTheme { // Ensure this theme exists
        InteractiveGreeting()
    }
}
