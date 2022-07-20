package com.example.clock.ui.theme.clockUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeTabBar(
    tabSelected: ClockFace,
    onTabSelected: (ClockFace) -> Unit,
    modifier: Modifier = Modifier
) {
        CraneTabs(
            modifier = modifier,
            titles = ClockFace.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = { newTab -> onTabSelected(ClockFace.values()[newTab.ordinal]) }
        )
}

enum class ClockFace {
    lines, circle, bars
}
@Composable
fun CraneTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: ClockFace,
    onTabSelected: (ClockFace) -> Unit
) {
    TabRow(
        selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        contentColor = Color.LightGray,
        indicator = { tabPositions: List<TabPosition> ->
            Box(
                Modifier.tabIndicatorOffset(tabPositions[tabSelected.ordinal])
                    .fillMaxSize()
                    .padding(horizontal = 4.dp)
                    .border(BorderStroke(2.dp, Color.White), RoundedCornerShape(16.dp))
            )
        },
        divider = { }
    ) {
        titles.forEachIndexed { index, title ->
            val selected = index == tabSelected.ordinal

            val textModifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)

            Tab(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                selected = selected,
                onClick = {
                    onTabSelected(ClockFace.values()[index])
                }
            ) {
                Text(
                    modifier = textModifier,
                    text = title.uppercase()
                )
            }
        }
    }
}