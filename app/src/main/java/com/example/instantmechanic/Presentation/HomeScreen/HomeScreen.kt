package com.example.instantmechanic.Presentation.HomeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.instantmechanic.MechanicViewModel
import com.example.instantmechanic.Navigation.Screen
import com.example.instantmechanic.R
import com.example.whatsappclone.presentation.homeScreen.BottomBar

@Composable
fun HomeScreen(viewModel: MechanicViewModel= viewModel(),
               navController : NavHostController) {

    var searchQuery by remember {
        mutableStateOf("")
    }
    var selectedFilter by remember {
        mutableStateOf("All Services")
    }

    val filteredMechanics = viewModel.mechanics.filter { mechanic ->

        mechanic.garageName.contains(
            searchQuery,
            ignoreCase = true
        ) ||
                mechanic.location.contains(
                    searchQuery,
                    ignoreCase = true
                ) ||
                mechanic.services.any { service ->
                    service.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }
    }



    Scaffold(
        bottomBar = { BottomBar() }

    ) {

        Column(modifier = Modifier.padding(it)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { },
                    tint = Color.Black
                )

                Text(
                    "Instant Mechanic",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold, fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )


                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { },
                    tint = Color.Black
                )
            }

            HorizontalDivider()

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier.padding(16.dp)) {

                OutlinedTextField(

                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    placeholder = { Text("Search mechanics, garages, services") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)

                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow() {

                    item {
                        FilterChipDesign(filterChipModel = FilterChipModel(title = "All Services"))

                        Spacer(modifier = Modifier.width(10.dp))

                        FilterChipDesign(filterChipModel = FilterChipModel(title = "General"))

                        Spacer(modifier = Modifier.width(10.dp))

                        FilterChipDesign(filterChipModel = FilterChipModel(title = "Body Work"))
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))



                if (viewModel.isLoading) {

                    CircularProgressIndicator()

                } else if (viewModel.errorMessage != null) {

                    Text(
                        text = "Error: ${viewModel.errorMessage}",
                        modifier = Modifier.padding(16.dp)
                    )

                } else {

                    LazyColumn {
                        items(filteredMechanics) { mechanic ->

                            GarageCard(
                                mechanic = mechanic,
                                onBookClick = {
                                    navController.navigate(
                                        "mechanicDetails/${mechanic.id}"
                                    )
                                }
                            )
                        }
                    }
                }

            }
        }
    }


}