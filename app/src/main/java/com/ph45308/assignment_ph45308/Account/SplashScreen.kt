package com.ph45308.assignment_ph45308.Account

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ph45308.assignment_ph45308.Account.ui.theme.Assignment_PH45308Theme
import com.ph45308.assignment_ph45308.R

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_PH45308Theme {
                PreviewSplash()
            }
        }
    }
}

@Composable
fun Splash() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "main image",
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(40.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplash() {
    Assignment_PH45308Theme {
        Splash()
    }
}