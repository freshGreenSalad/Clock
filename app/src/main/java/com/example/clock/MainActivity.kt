package com.example.clock
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.clock.ui.theme.clockUI.ClockFace
import com.example.clock.ui.theme.clockUI.DropdownDemo
import com.example.clock.ui.theme.clockUI.HomeTabBar
import com.example.clock.ui.theme.clockUI.SearchContent
import com.ramcosta.composedestinations.DestinationsNavHost
import kotlinx.coroutines.delay
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           TryToDrawArk()
        }
    }
}


@Composable
fun TryToDrawArk(
) {
    var seconds by remember {
        mutableStateOf(0)
    }
    var minutes by remember {
        mutableStateOf(0)
    }
    var hours by remember {
        mutableStateOf(0)
    }
    val timezone by remember {
        mutableStateOf("New Zealand")
    }
    LaunchedEffect(key1 = seconds, key2 = hours, key3 = minutes) {
        delay(1000L)
        seconds = Calendar.getInstance(TimeZone.getTimeZone(timezone)).get(Calendar.SECOND)
        hours = Calendar.getInstance(TimeZone.getTimeZone(timezone)).get(Calendar.HOUR)
        minutes = Calendar.getInstance(TimeZone.getTimeZone(timezone)).get(Calendar.MINUTE)
    }
    Column {
        DropdownDemo()
    }
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomCenter
) {
    var tabSelected by remember { mutableStateOf(ClockFace.lines) }

    SearchContent(tabSelected,seconds, minutes, hours)
    HomeTabBar(
        tabSelected,
        onTabSelected = { tabSelected = it }
    )
}
}







