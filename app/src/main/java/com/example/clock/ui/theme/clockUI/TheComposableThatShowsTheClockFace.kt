package com.example.clock.ui.theme.clockUI

import androidx.compose.animation.*
import androidx.compose.runtime.Composable


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchContent(
    tabSelected: ClockFace,
    seconds:Int,
    minutes:Int,
    hours:Int
) {
    AnimatedContent(
        targetState = tabSelected,

    ) { targetState ->
        when (targetState) {
            ClockFace.circle -> CircularClock(seconds, minutes, hours)
            ClockFace.lines -> LineClock(seconds, minutes, hours)
            ClockFace.bars -> BarClock(seconds, minutes, hours)
        }
    }
}