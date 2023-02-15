package ca.josue.jetgmail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue.jetgmail.R
import ca.josue.jetgmail.ui.theme.spacing

@Composable
fun HomeAppBar() {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ){
        Card(
            modifier = Modifier
                .requiredHeight(50.dp)
            ,
            shape = RoundedCornerShape(10.dp),
            elevation = 6.dp
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menu"
                )
                Text(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.small)
                        .weight(2f),
                    text = "Search in emails"
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Profile"
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar()
}