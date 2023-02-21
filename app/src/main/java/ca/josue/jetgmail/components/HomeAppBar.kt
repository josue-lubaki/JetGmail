package ca.josue.jetgmail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue.jetgmail.R
import ca.josue.jetgmail.ui.theme.contentColor
import ca.josue.jetgmail.ui.theme.spacing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(
    scaffoldState: ScaffoldState,
    scope : CoroutineScope,
    openDialog : MutableState<Boolean>
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ){
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 6.dp
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically,
            ){
                IconButton(onClick =  {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }){
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = colors.contentColor
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.small)
                        .weight(2f),
                    text = "Search in email",
                    color = colors.contentColor
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .clickable {
                            openDialog.value = true
                        },
                    painter = painterResource(id = R.drawable.me),
                    contentDescription = "Profile"
                )

                if(openDialog.value){
                    AccountsDialog(openDialog = openDialog)
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar(
        scaffoldState = rememberScaffoldState(),
        scope = rememberCoroutineScope(),
        remember { mutableStateOf(false) }
    )
}