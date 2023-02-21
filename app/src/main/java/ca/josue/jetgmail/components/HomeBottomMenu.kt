package ca.josue.jetgmail.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ca.josue.jetgmail.model.GmailBottomMenu
import ca.josue.jetgmail.ui.theme.contentColor

@Composable
fun HomeBottomMenu() {
    val items = listOf(
        GmailBottomMenu.Mail,
        GmailBottomMenu.Meet,
    )

    BottomNavigation(
        backgroundColor = colors.surface,
        contentColor = colors.contentColor
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                label = {Text(text = item.title, color = colors.contentColor)},
                alwaysShowLabel = true,
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = colors.contentColor
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