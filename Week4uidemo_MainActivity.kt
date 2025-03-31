package com.example.week4uidemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week4uidemo.ui.theme.Week4UIDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4UIDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyButtons(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyButtons(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            Toast.makeText(context, "Button 1 clicked!", Toast.LENGTH_SHORT).show()
        }) {
            Text("TABLET BTN 1")
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(onClick = {
            Toast.makeText(context, "Button 2 clicked!", Toast.LENGTH_SHORT).show()
        }) {
            Text("TABLET BTN 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonsPreview() {
    Week4UIDemoTheme {
        MyButtons()
    }
}
