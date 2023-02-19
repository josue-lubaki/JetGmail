package ca.josue.jetgmail.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material.icons.filled.LabelImportant
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.ScheduleSend
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Label
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val title : String? = null,
    val icon : ImageVector? = null,
    val isDivider : Boolean = false,
    val isHeader : Boolean = false,
){
    object AllInboxes : DrawerMenuData(
        title = "All Inboxes",
        icon = Icons.Filled.AllInbox,
    )
    object Primary : DrawerMenuData(
        title = "Primary",
        icon = Icons.Filled.Inbox,
    )
    object Social : DrawerMenuData(
        title = "Social",
        icon = Icons.Filled.People,
    )
    object Promotions : DrawerMenuData(
        title = "Promotions",
        icon = Icons.Filled.Discount,
        isDivider = true,
        isHeader = true,
    )
    object Starred : DrawerMenuData(
        title = "Starred",
        icon = Icons.Filled.Star,
    )
    object Snoozed : DrawerMenuData(
        title = "Snoozed",
        icon = Icons.Filled.Schedule,
    )
    object Important : DrawerMenuData(
        title = "Important",
        icon = Icons.Filled.LabelImportant,
    )
    object Sent : DrawerMenuData(
        title = "Sent",
        icon = Icons.Filled.Send,
    )
    object Scheduled : DrawerMenuData(
        title = "Scheduled",
        icon = Icons.Filled.ScheduleSend,
    )
    object Drafts : DrawerMenuData(
        title = "Drafts",
        icon = Icons.Filled.InsertDriveFile,
    )
    object AllMails : DrawerMenuData(
        title = "All mail",
        icon = Icons.Filled.Mail,
    )
    object Spam : DrawerMenuData(
        title = "Spam",
        icon = Icons.Filled.Report,
    )
    object Trash : DrawerMenuData(
        title = "Trash",
        icon = Icons.Filled.Delete,
    )
    object History : DrawerMenuData(
        title = "Historic mails",
        icon = Icons.Outlined.Label,
    )
    object SpamBox : DrawerMenuData(
        title = "SpamBox",
        icon = Icons.Outlined.Label,
    )
    object Settings : DrawerMenuData(
        title = "Settings",
        icon = Icons.Filled.Settings,
    )
    object Help : DrawerMenuData(
        title = "Help",
        icon = Icons.Filled.Help,
    )
    object SendFeedback : DrawerMenuData(
        title = "Send feedback",
        icon = Icons.Filled.Feedback,
    )
    object Divider : DrawerMenuData(
        isDivider = true,
    )
    object HeaderEtiquette : DrawerMenuData(
        isHeader = true,
        title = "ÉTIQUETTES",
    )
}

