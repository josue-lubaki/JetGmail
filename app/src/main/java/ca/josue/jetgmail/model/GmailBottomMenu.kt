package ca.josue.jetgmail.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class GmailBottomMenu(
    val icon : ImageVector,
    val title : String,
) {
    object Mail : GmailBottomMenu(
        icon = Icons.Outlined.Mail,
        title = "Mail",
    )

    object Meet : GmailBottomMenu(
        icon = Icons.Outlined.VideoCall,
        title = "Meet",
    )
}