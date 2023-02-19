package ca.josue.jetgmail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ca.josue.jetgmail.components.GmailDrawerMenu
import ca.josue.jetgmail.components.HomeAppBar
import ca.josue.jetgmail.components.HomeBottomMenu
import ca.josue.jetgmail.components.MailList
import ca.josue.jetgmail.ui.theme.JetGmailTheme

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
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState = scaffoldState, scope = coroutineScope) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        },
        bottomBar = { HomeBottomMenu() },
    ) {
        MailList(it)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetGmailTheme {
        JetGmailApp()
    }
}