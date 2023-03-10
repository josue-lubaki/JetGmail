package ca.josue.jetgmail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ca.josue.jetgmail.R
import ca.josue.jetgmail.accountList
import ca.josue.jetgmail.model.AccountData
import ca.josue.jetgmail.ui.theme.backgroundColor
import ca.josue.jetgmail.ui.theme.contentColor

@Composable
fun AccountsDialog(openDialog : MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false }) {
        AccountDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountDialogUI(
    modifier : Modifier = Modifier,
    openDialog : MutableState<Boolean>
) {
    Card {
        Column(modifier = modifier
            .background(colors.backgroundColor)
            .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
               IconButton(onClick = { openDialog.value = false }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = colors.contentColor
                    )
               }
                Image(
                    modifier = modifier
                        .size(30.dp)
                        .weight(2f)
                        .padding(end = 32.dp),
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Account Icon"
                )
            }

            AccountItem(
                modifier = modifier,
                account = AccountData(
                    username = "Josue Lubaki",
                    email = "josuelubaki@gmail.com",
                    avatar = R.drawable.me,
                    unReadCount = 99
                )
            )

            Row( modifier = modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceEvenly,
            ){
                Card(
                    modifier = modifier.padding(start = 48.dp),
                    shape= RoundedCornerShape(50.dp),
                    border= BorderStroke(1.dp, color = Color.Gray),
                ){
                    Text(
                        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        text = stringResource(R.string.manage_your_gmail_account),
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        color = colors.contentColor
                    )
                }
                Spacer(modifier = modifier.width(10.dp))
            }

            Divider(modifier = modifier.padding(top = 16.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier = modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.cloud),
                    contentDescription = "Cloud Icon",
                    tint = colors.contentColor
                )
                Text(
                    modifier = modifier.padding(start = 16.dp),
                    text = "Storage used: 78% of 15 GB",
                    color = colors.contentColor,
                    fontSize = 13.sp,
                )
            }

            Divider(modifier = modifier.padding(bottom = 16.dp))

            accountList.forEach {
                AccountItem(
                    modifier = modifier,
                    account = it
                )
            }

            Divider(modifier = modifier.padding(bottom = 16.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.PersonAddAlt,
                    contentDescription = "Add Icon",
                    tint = colors.contentColor
                )
                Text(
                    modifier = modifier.padding(start = 16.dp),
                    text = "Add another account",
                    color = colors.contentColor
                )
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Outlined.ManageAccounts,
                    contentDescription = "Person Setting",
                    tint = colors.contentColor
                )
                Text(
                    modifier = modifier.padding(start = 16.dp),
                    text = "Manage accounts on this device",
                    color = colors.contentColor
                )
            }

            Divider(modifier = modifier.padding(16.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = "Privacy Policy",
                    color = colors.contentColor,
                    fontSize = 13.sp,
                )
                Text(
                    text = "Terms of Service",
                    color = colors.contentColor,
                    fontSize = 13.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountDialogUIPreview() {
    AccountDialogUI(
        openDialog = remember {
            mutableStateOf(true)
        }
    )
}