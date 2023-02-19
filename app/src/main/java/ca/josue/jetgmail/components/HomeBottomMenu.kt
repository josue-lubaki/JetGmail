package ca.josue.jetgmail.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ca.josue.jetgmail.model.GmailBottomMenu

@Composable
fun HomeBottomMenu() {
    val items = listOf(
        GmailBottomMenu.Mail,
        GmailBottomMenu.Meet,
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                label = {Text(text = item.title)},
                alwaysShowLabel = true,
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                ) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBottomMenuPreview() {
    HomeBottomMenu()
}