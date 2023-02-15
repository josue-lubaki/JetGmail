package ca.josue.jetgmail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ca.josue.jetgmail.components.HomeAppBar
import ca.josue.jetgmail.ui.theme.JetGmailTheme
import ca.josue.jetgmail.ui.theme.spacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetGmailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    JetGmailApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JetGmailApp() {
    Scaffold(
        topBar = {HomeAppBar()},
        bottomBar = {},
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetGmailTheme {
        JetGmailApp()
    }
}