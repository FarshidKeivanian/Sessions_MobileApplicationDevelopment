package com.example.sharedpreferencesexample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sharedpreferencesexample.ui.theme.SharedPreferencesExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedPreferencesExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        SaveAndLoadDataExample()
                        Spacer(modifier = Modifier.height(32.dp))
                        SettingsScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun SaveAndLoadDataExample() {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                    .edit().putString("username", name).apply()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Name")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                name = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                    .getString("username", "") ?: ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Load Name")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Saved Name: $name")
    }
}

@Composable
fun SettingsScreen() {
    val context = LocalContext.current

    var notificationsEnabled by remember {
        mutableStateOf(
            context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
                .getBoolean("notifications", true)
        )
    }

    val isDarkMode = remember {
        mutableStateOf(PreferenceManager.isDarkModeEnabled(context))
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Settings", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Enable Notifications")
        Switch(
            checked = notificationsEnabled,
            onCheckedChange = {
                notificationsEnabled = it
                context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
                    .edit().putBoolean("notifications", it).apply()
            }
        )
        Text(
            text = if (notificationsEnabled) "Notifications Enabled" else "Notifications Disabled",
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Enable Dark Mode")
        Switch(
            checked = isDarkMode.value,
            onCheckedChange = {
                isDarkMode.value = it
                PreferenceManager.setDarkMode(context, it)
            }
        )
        Text(
            text = if (isDarkMode.value) "Dark Mode On" else "Dark Mode Off",
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSaveAndLoadDataExample() {
    SharedPreferencesExampleTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            SaveAndLoadDataExample()
            Spacer(modifier = Modifier.height(32.dp))
            SettingsScreen()
        }
    }
}
