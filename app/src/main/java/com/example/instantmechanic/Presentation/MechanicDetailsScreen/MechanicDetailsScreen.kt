package com.example.instantmechanic.Presentation.MechanicDetailsScreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.instantmechanic.Navigation.Screen
import com.example.instantmechanic.R
import com.example.instantmechanic.model.Mechanic

@Composable
fun MechanicDetailsScreen(
    navController: NavHostController,
    mechanic: Mechanic,
    onBackClick: () -> Unit = {},
    onRequestServiceClick: () -> Unit = {}
) {

    val context = LocalContext.current

    Scaffold(){

        Column(modifier = Modifier.padding(it)){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                // ---------------- TOP BAR ----------------

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.clickable{

                            navController.navigate(Screen.HomeScreen.route)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }

                    Text(
                        text = "Mechanic Details",
                        modifier = Modifier.weight(1f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More"
                        )
                    }
                }


                // ---------------- SCROLLABLE CONTENT ----------------

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 12.dp)
                ) {

                    // Garage Image

                    Image(
                        painter = painterResource(
                            id = R.drawable.garage
                        ),
                        contentDescription = mechanic.garageName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    // OPEN + RATING

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFFE8F5E9)
                        ) {

                            Text(
                                text = if (mechanic.isOpen) "OPEN" else "CLOSED",
                                color = if (mechanic.isOpen)
                                    Color(0xFF2E7D32)
                                else
                                    Color(0xFFC62828),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                )
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = mechanic.rating.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    // GARAGE NAME

                    Text(
                        text = mechanic.garageName,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))


                    // ADDRESS

                    Row(
                        verticalAlignment = Alignment.Top
                    ) {

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            modifier = Modifier.size(18.dp),
                            tint = Color.Gray
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Column {

                            Text(
                                text = mechanic.address,
                                fontSize = 12.sp,
                                color = Color.DarkGray
                            )

                            Text(
                                text = mechanic.location,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    // PHONE BUTTON

                    OutlinedButton(
                        onClick = {

                            val intent = Intent(
                                Intent.ACTION_DIAL,
                                Uri.parse("tel:${mechanic.phone}")
                            )

                            context.startActivity(intent)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(6.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone",
                            modifier = Modifier.size(17.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = mechanic.phone,
                            fontSize = 13.sp
                        )
                    }


                    Spacer(modifier = Modifier.height(18.dp))


                    // ---------------- SERVICES ----------------

                    Text(
                        text = "Available Services",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    mechanic.services.chunked(2).forEach { rowServices ->

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            rowServices.forEach { service ->

                                ServiceItem(
                                    service = service,
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            // Keeps the last row aligned
                            if (rowServices.size == 1) {
                                Spacer(
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                    }


                    Spacer(modifier = Modifier.height(10.dp))


                    // ---------------- WORKING HOURS ----------------

                    Text(
                        text = "Working Hours",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF8F8F8)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {

                            Text( mechanic.workingHours)


                        }
                    }


                    Spacer(modifier = Modifier.height(18.dp))


                    // ---------------- LOCATION ----------------

                    Text(
                        text = "Location",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    // Temporary map placeholder
                    // Replace this with Google Maps later.

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE8E8E8)),
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Map Location",
                                tint = Color(0xFFFF6D00),
                                modifier = Modifier.size(35.dp)
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = mechanic.location,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }


                // ---------------- REQUEST SERVICE ----------------

                Button(
                    onClick = { navController.navigate(
                        "bookAService/${mechanic.id}"
                    ) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        )
                        .navigationBarsPadding()
                        .height(50.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.BookNowButtonColor)
                    )
                ) {

                    Text(
                        text = "Request Service",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}