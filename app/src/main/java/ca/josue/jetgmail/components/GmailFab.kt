package ca.josue.jetgmail.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(scrollState : ScrollState) {

    if (scrollState.value > 100) {
        ExtendedFloatingActionButton(
            text = {
                Text(
                    text = "Compose",
                    fontSize = 16.sp)
                },
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit icon"
                )
            },
            backgroundColor = MaterialTheme.colors.surface,
            onClick = { /*TODO*/ }
        )
    }
    else {
        FloatingActionButton(
            backgroundColor = MaterialTheme.colors.surface,
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit icon"
            )
        }
    }
}

@Preview
@Composable
fun GmailFabPreview() {
    GmailFab(rememberScrollState())
}