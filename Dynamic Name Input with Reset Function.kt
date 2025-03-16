@Composable
fun InteractiveGreetingWithClearButton(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }

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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Update greeting */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Greet Me")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { name = "" }, // Clear the input field
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
            ) {
                Text(text = "Clear")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Hello, $name!", style = MaterialTheme.typography.headlineLarge)
    }
}
