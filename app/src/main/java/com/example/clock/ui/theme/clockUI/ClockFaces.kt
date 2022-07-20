package com.example.clock.ui.theme.clockUI

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun CircularClock(
    seconds:Int,
    minutes:Int,
    hours:Int
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(300.dp)
        ) {
            drawArc(
                color = Color.Black,
                startAngle = -90f,
                sweepAngle = (6f * seconds.toFloat()),
                useCenter = false,
                topLeft = Offset(((size.width) / 2f) - 240f, ((size.height) / 2f) - 240f),
                size = Size(480f, 480f),
                style = Stroke(15f, cap = StrokeCap.Round)
            )
            drawArc(
                Color.Red,
                startAngle = -90f,
                sweepAngle = (6f * minutes.toFloat()),
                useCenter = false,
                topLeft = Offset(((size.width) / 2f) - 260f, ((size.height) / 2f) - 260f),
                size = Size(520f, 520f),
                style = Stroke(15f, cap = StrokeCap.Round)
            )
            drawArc(
                Color.Blue,
                startAngle = -90f,
                sweepAngle = ((30f * hours.toFloat()) + (minutes.toFloat() / 4f)),
                useCenter = false,
                topLeft = Offset(((size.width) / 2f) - 280f, ((size.height) / 2f) - 280f),
                size = Size(560f, 560f),
                style = Stroke(15f, cap = StrokeCap.Round)
            )
        }
    }
}

@Composable
fun LineClock(
    seconds:Int,
    minutes:Int,
    hours:Int
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier
            .size(300.dp)
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(0f,600f),
                end = Offset(seconds*12f,600-seconds*5f),
                strokeWidth = 15f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Red,
                start = Offset(0f,580f),
                end = Offset(minutes*12f,580-minutes*5f),
                strokeWidth = 15f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Blue,
                start = Offset(0f,560f),
                end = Offset(hours*60f,560-hours*25f),
                strokeWidth = 15f,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun BarClock(
    seconds:Int,
    minutes:Int,
    hours:Int
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(300.dp)
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(center.x-200, 600f),
                end = Offset(center.x-200, 600 - seconds * 10f),
                strokeWidth = 200f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Red,
                start = Offset(center.x, 600f),
                end = Offset(center.x, 600f - minutes * 10f),
                strokeWidth = 200f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Blue,
                start = Offset(center.x+200, 600f),
                end = Offset(center.x+200, 600f - hours * 50f),
                strokeWidth = 200f,
                cap = StrokeCap.Round

            )
        }
    }
}