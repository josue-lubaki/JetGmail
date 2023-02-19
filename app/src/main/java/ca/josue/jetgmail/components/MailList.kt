package ca.josue.jetgmail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.josue.jetgmail.R
import ca.josue.jetgmail.mailsList
import ca.josue.jetgmail.model.MailData
import ca.josue.jetgmail.ui.theme.StarColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MailList(paddingValues: PaddingValues) {
    val mockData = mailsList

    Box(
        modifier = Modifier.padding(paddingValues)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ){
            items(mockData){
                MailItem(mailData = it)
            }
        }
    }
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {

    var isClicked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
       Card(
           modifier = Modifier
               .padding(end = 8.dp)
               .size(40.dp)
               .clip(shape = CircleShape),
            backgroundColor = Color.Gray
       ){
           Text(
               text = mailData.username.first().toString(),
               textAlign = TextAlign.Center,
               modifier = Modifier.padding(8.dp)
           )
       }

        Column(
            modifier = Modifier.weight(2f).animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow,
                )
            )
                .clickable {
                      isClicked = !isClicked
                },
        ){
            Text(
                text = mailData.username,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mailData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = if(isClicked) Int.MAX_VALUE else 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = mailData.body,
                fontSize = 14.sp,
                maxLines = if(isClicked) Int.MAX_VALUE else 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Column {
            Text(
                text = mailData.timestamp,
                textAlign = TextAlign.End,
            )
            IconButton(
                onClick = {

                },
                modifier = Modifier.size(50.dp).padding(top = 8.dp, start = 16.dp)
            ){
                Icon(
                    imageVector = if(mailData.isStarred) Icons.Filled.Star else Icons.Outlined.StarOutline,
                    contentDescription = stringResource(R.string.star_icon),
                    tint = if(mailData.isStarred) StarColor else Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview() {
    MailItem(
        mailData = MailData(
            mailId = 1,
            username = "John",
            body = "This is the body of the message",
            subject = "Subject",
            timestamp = "12:01"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun MailListPreview() {
    MailList(
        paddingValues = PaddingValues(16.dp),
    )
}