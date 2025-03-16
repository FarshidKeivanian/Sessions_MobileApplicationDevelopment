import java.util.Calendar

@Composable
fun InteractiveGreetingWithTimeBasedMessage(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    val greetingMessage = when {
        currentHour in 5..11 -> "Good Morning"
        currentHour in 12..17 -> "Good Afternoon"
        else -> "Good Evening"
    }

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
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* Updates UI */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Greet Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "$greetingMessage, $name!", style = MaterialTheme.typography.headlineLarge)
    }
}
