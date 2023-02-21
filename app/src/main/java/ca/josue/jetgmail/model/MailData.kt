package ca.josue.jetgmail.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class MailData(
    val mailId : Int,
    val username : String,
    val subject : String,
    val body : String,
    val isRead : Boolean = false,
    val isStarred : Boolean = false,
    val color: Color = Color.Gray,
    val timestamp : String = ""
)

data class AccountData(
    val username : String,
    val email : String,
    val avatar : Int,
    val unReadCount : Int = 0,
)
