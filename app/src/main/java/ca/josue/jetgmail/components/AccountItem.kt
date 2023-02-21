package ca.josue.jetgmail.components

import android.accounts.Account
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.josue.jetgmail.model.AccountData
import ca.josue.jetgmail.ui.theme.contentColor

@Composable
fun AccountItem(
    modifier: Modifier = Modifier,
    account: AccountData
) {
    Row(
        modifier = modifier.padding(start = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            painter = painterResource(id = account.avatar),
            contentDescription = "Account Icon"
        )

        Column(modifier = modifier
            .weight(2f)
            .padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = account.username,
                fontWeight = FontWeight.SemiBold,
                color = colors.contentColor
            )
            Text(
                text = account.email,
                color = colors.contentColor,
                fontSize = 13.sp
            )
        }

        Text(
            modifier = modifier.padding(end = 16.dp, top = 16.dp),
            text = "${account.unReadCount}+",
            color = colors.contentColor
        )
    }
}