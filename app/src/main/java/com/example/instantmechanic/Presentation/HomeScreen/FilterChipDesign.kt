package com.example.instantmechanic.Presentation.HomeScreen

import androidx.compose.foundation.layout.height


import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instantmechanic.R

@Composable
fun FilterChipDesign(
    filterChipModel: FilterChipModel
) {

    var isSelected by remember() {
        mutableStateOf(false)
    }

    FilterChip(
        selected = isSelected,
        onClick = { isSelected = !isSelected },

        label = {
            Text(
                text = filterChipModel.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        },



        shape = RoundedCornerShape(10.dp),

        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = colorResource(R.color.selectedChipColor),
            selectedLabelColor = Color.White,
            containerColor = Color.White,
            labelColor = Color.Black
        ),

        border = null,

        modifier = Modifier.height(50.dp)
            .width(120.dp)
    )
}