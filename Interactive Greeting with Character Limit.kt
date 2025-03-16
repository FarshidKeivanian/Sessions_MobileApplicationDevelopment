@Composable
fun InteractiveGreetingWithCounter(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    val charLimit = 20

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                if (it.length <= charLimit) name = it
            },
            label = { Text("Enter your name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Characters: ${name.length}/$charLimit",
            color = if (name.length == charLimit) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Hello, $name!", style = MaterialTheme.typography.headlineLarge)
    }
}
