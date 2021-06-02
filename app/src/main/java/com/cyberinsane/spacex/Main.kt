package com.cyberinsane.spacex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberinsane.spacex.ui.theme.CyberSpaceXTheme

@Composable
fun Main() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar()
        Spacer(modifier = Modifier.height(32.dp))
        UpcomingLaunches()
        Spacer(modifier = Modifier.height(32.dp))
        LaunchesButton()
        Spacer(modifier = Modifier.height(16.dp))
        RocketsButton()
        Spacer(modifier = Modifier.height(16.dp))
        CompanyButton()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier.background(Color.Black),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun UpcomingLaunches() {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .clip(CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Upcoming Launch", modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun RocketsButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(stringResource(id = R.string.rockets))
    }
}

@Composable
fun LaunchesButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(stringResource(id = R.string.launches))
    }
}

@Composable
fun CompanyButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(stringResource(id = R.string.about_space_x))
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CyberSpaceXTheme {
        Main()
    }
}
