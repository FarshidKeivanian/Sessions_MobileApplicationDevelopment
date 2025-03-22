package com.example.menusandpickersdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menusandpickersdemo.ui.theme.MenusAndPickersDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenusAndPickersDemoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SimpleDropdown()
                }
            }
        }
    }
}

@Composable
fun SimpleDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select") }

    Box(modifier = Modifier
        .padding(16.dp)) {
        Text(
            text = selectedOption,
            modifier = Modifier
                .clickable { expanded = true }
                .padding(8.dp)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Option A") },
                onClick = {
                    selectedOption = "Option A"
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Option B") },
                onClick = {
                    selectedOption = "Option B"
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDropdown() {
    MenusAndPickersDemoTheme {
        SimpleDropdown()
    }
}
