package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            ComposeInfoCard(
                title = stringResource(R.string.text_composable),
                desc = stringResource(R.string.texta_composable_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)  //todo this one modifier is getting passed down into the card
            )

            ComposeInfoCard(
                title = stringResource(R.string.image_composable),
                desc = stringResource(R.string.image_composable_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f)
        ) {
            ComposeInfoCard(
                title = stringResource(R.string.row_composable),
                desc = stringResource(R.string.row_composable_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )

            ComposeInfoCard(
                title = stringResource(R.string.column_composable),
                desc = stringResource(R.string.column_composable_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposeInfoCard(
    title: String,
    desc: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier //todo modifier issue split  ..... it is passed from the QuadrantApp
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }

}


@Preview(showBackground = true)
@Composable
fun ComposeInfoCardPreview() {
    ComposeQuadrantTheme {
        ComposeInfoCard(
            "Text composable",
            "Displays text and follows the recommended Material Design guidelines.",
            Color(0xFFB69DF8)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }

}