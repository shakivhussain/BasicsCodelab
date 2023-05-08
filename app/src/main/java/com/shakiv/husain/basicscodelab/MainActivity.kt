package com.shakiv.husain.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shakiv.husain.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf("Compose", "World")) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        Column(modifier = modifier.padding(4.dp)) {
            for (name in names) {
                Greeting("$name")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val expanded = remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
            ) {
                Text(text = "Hello")
                Text(text = "$name!")
            }

            ElevatedButton(
                onClick = { expanded.value = !expanded.value },
                modifier
            ) {
                Text(
                    if (expanded.value) "Show Less" else "Show More"
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun AppReview() {
    MyApp()
}