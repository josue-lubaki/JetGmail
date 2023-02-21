package ca.josue.jetgmail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.josue.jetgmail.model.DrawerMenuData
import ca.josue.jetgmail.R

@Composable
fun GmailDrawerMenu(scrollState: ScrollState) {

    val menuList = listOf(
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,

        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.Divider,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Scheduled,
        DrawerMenuData.Drafts,
        DrawerMenuData.AllMails,
        DrawerMenuData.Spam,
        DrawerMenuData.Trash,
        DrawerMenuData.Divider,

        DrawerMenuData.HeaderEtiquette,
        DrawerMenuData.History,
        DrawerMenuData.SpamBox,
        DrawerMenuData.Divider,

        DrawerMenuData.Settings,
        DrawerMenuData.Help,
        DrawerMenuData.SendFeedback,
    )

    Column(
        modifier = Modifier
            .padding(start = 15.dp, top = 20.dp)
            .fillMaxWidth()
    ) {
       Row(
           verticalAlignment = Alignment.CenterVertically,
       ){
           Image(
               modifier = Modifier
                   .size(36.dp)
                   .weight(0.15f),
               painter = painterResource(id = R.drawable.ggle),
               contentDescription = stringResource(R.string.jetgmail_logo),
           )
           Text(
               modifier = Modifier.weight(1f),
               text = stringResource(R.string.google),
               color = Color.Black.copy(alpha = 0.6f),
               fontSize = 20.sp,
               fontWeight = FontWeight.Bold,
           )
       }

        Divider(modifier = Modifier.padding(top = 16.dp))

        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ){
            menuList.forEach {
                when(it){
                    DrawerMenuData.Divider -> Divider(modifier = Modifier.padding(start = 50.dp, top = 16.dp))
                    DrawerMenuData.HeaderEtiquette -> HeaderEtiquette(it)
                    else -> MailDrawerItem(it)
                }
            }
        }
    }
}

@Composable
fun HeaderEtiquette(item : DrawerMenuData) {
    Text(
        text = item.title!!,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        color = Color.Gray,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    )
}

@Composable
fun MailDrawerItem(item : DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Image(
            modifier = Modifier.weight(0.15f),
            imageVector = item.icon!!,
            contentDescription = item.title,
        )
        Text(
            text = item.title!!,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderEtiquettePreview() {
    HeaderEtiquette(DrawerMenuData.HeaderEtiquette)
}

@Preview(showBackground = true)
@Composable
fun MailDrawerItemPreview() {
    MailDrawerItem(DrawerMenuData.AllInboxes)
}

@Preview(showBackground = true)
@Composable
fun GmailDrawerMenuPreview() {
    GmailDrawerMenu(rememberScrollState())
}