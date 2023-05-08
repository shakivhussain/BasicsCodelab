package com.shakiv.husain.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnBoarding by remember { mutableStateOf(true) }
    Surface(modifier) {
        if (shouldShowOnBoarding) {
            OnBoardingScreen(onContinueClicked = { shouldShowOnBoarding = false })
        } else {
            Greetings(modifier = modifier)
        }
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppReview() {
    BasicsCodelabTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        Column(modifier = Modifier.padding(4.dp)) {
            for (name in names) {
                Greeting("$name")
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

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
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = "$name!")
            }

            ElevatedButton(
                onClick = { expanded.value = !expanded.value },
                modifier.padding(start = 8.dp)
            ) {
                Text(
                    if (expanded.value) "Show Less" else "Show More"
                )
            }
        }
    }
}


@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { onContinueClicked() }
        ) {
            Text(text = "Continue")
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewOnBoardingScreen() {
    BasicsCodelabTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}