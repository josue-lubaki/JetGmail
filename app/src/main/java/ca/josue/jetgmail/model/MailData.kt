package ca.josue.jetgmail.model

import androidx.compose.ui.graphics.Color

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
