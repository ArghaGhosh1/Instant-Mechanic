package com.example.instantmechanic.Presentation.BookAService

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instantmechanic.R
import com.example.instantmechanic.model.Mechanic
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAService(

    mechanic: Mechanic
) {

    var full_name by remember(){
        mutableStateOf("")
    }

    var phoneNumber by remember(){
        mutableStateOf("")
    }

    var vehicleReg by remember(){
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedService by remember {
        mutableStateOf("")
    }

    Scaffold() {
        Column(modifier = Modifier.padding(it)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    painter = painterResource(R.drawable.search),
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

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {

                Text(
                    "Book a Service",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Provide vehicle details for instant dispatch.",
                    fontSize = 16.sp, color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(50.dp))



                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                ) {

                    Column(modifier = Modifier.padding(20.dp)) {

                        Spacer(modifier = Modifier.height(15.dp))///////////////////////////

                        Text("Customer Name", color = Color.Gray, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))


                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = full_name,
                            onValueChange = { full_name = it },
                            placeholder = {

                                Text("Argha Ghosh", color = Color.Gray)
                            }
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text("Phone Number", color = Color.Gray, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            placeholder = { Text("(555) 123-4567", color = Color.Gray) }
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text("Vehicle Reg / VIN", color = Color.Gray, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = vehicleReg,
                            onValueChange = { vehicleReg = it },
                            placeholder = { Text("ABC-123", color = Color.Gray) }
                        )


                        Spacer(modifier = Modifier.height(15.dp))

                        Text("Service Type", color = Color.Gray, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))



                        //dropdown

                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {

                            OutlinedTextField(
                                value = selectedService,
                                onValueChange = {},
                                readOnly = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(),
                                placeholder = {
                                    Text(
                                        text = "Select required service...",
                                        fontSize = 12.sp
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Build,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(
                                        expanded = expanded
                                    )
                                },
                                shape = RoundedCornerShape(4.dp)
                            )


                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {

                                mechanic.services.forEach { service ->

                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                text = service,
                                                fontSize = 13.sp
                                            )
                                        },
                                        onClick = {

                                            selectedService = service

                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Text("Customer Name", color = Color.Gray, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))


                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth()
                                .height(100.dp),
                            value = full_name,
                            onValueChange = { full_name = it },
                            placeholder = {

                                Text("Brifly Describe what's wrong ", color = Color.Gray)
                            }
                        )



                        Spacer(modifier = Modifier.height(15.dp))

                        Button(
                            onClick = {


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.BookNowButtonColor)
                            )

                        ) {

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "Submit Request",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                        }


                    }
                }
            }


        }
    }


}