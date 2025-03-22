package com.example.nameinputfielddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nameinputfielddemo.ui.theme.NameInputFieldDemoTheme

class NameInputFieldDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NameInputField()
        }
    }
}

@Composable
fun NameInputField() {
    var name by remember { mutableStateOf("") }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter name") }
        )
        Text("Hello, $name")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNameInputField() {
    NameInputField()
}
