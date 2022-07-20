package com.example.clock.ui.theme.clockUI

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Country(
    val country: String,
    val countryCode:String
)


@Composable
fun DropdownDemo() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf(
        Country("Auckland","Pacific/Auckland"),
        Country("Japan","Japan"),
        Country("London","Europe/London"),
        Country("Iceland","Iceland"),
        Country("Auckland","Pacific/Auckland")
        )
    var selectedIndex by remember { mutableStateOf(0) }
    var selecteditem by remember { mutableStateOf("Auckland") }
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
            .border(width = 3.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = { expanded = true })
    )
    {
        val item = items[selectedIndex]
        val (country, countryCode) = item
        Text(
            text = country,
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            fontSize = 16.sp
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
            offset = DpOffset(50.dp, 0.dp)
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }
                ) {
                    Text(text = s.country)
                }
            }
        }
    }
}