package com.example.instantmechanic.Presentation.RequestSubmitted

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.instantmechanic.Navigation.Screen

@Composable
fun RequestSubmittedScreen(
    navController: NavHostController
) {

    val orange = Color(0xFFFF7518)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        // ==============================
        // SUCCESS ICON
        // ==============================

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = Color(0xFFFFF1E8),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(58.dp)
                    .background(
                        color = orange,
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Success",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        // ==============================
        // TITLE
        // ==============================

        Text(
            text = "Request Submitted",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Successfully!",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Your instant mechanic is\nconfirmed. Help is on the way.",
            fontSize = 14.sp,
            color = Color.Gray,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(28.dp))


        // ==============================
        // BOOKING SUMMARY CARD
        // ==============================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(6.dp)
                ),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(14.dp)
            ) {

                // BOOKING SUMMARY

                Text(
                    text = "BOOKING SUMMARY",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(12.dp))


                // ==============================
                // MECHANIC
                // ==============================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .background(
                                color = Color(0xFFE8E8E8),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Column {

                        // HARDCODED NAME

                        Text(
                            text = "Alex Mercer",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        // HARDCODED RATING

                        Text(
                            text = "★ 4.9 (128 reviews)",
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(
                    color = Color(0xFFEAEAEA)
                )

                Spacer(modifier = Modifier.height(10.dp))


                // ==============================
                // EXPECTED CONTACT
                // ==============================

                SummaryRow(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(15.dp)
                        )
                    },
                    label = "Expected Contact",
                    value = "In 5-10 mins"
                )

                Spacer(modifier = Modifier.height(10.dp))


                // ==============================
                // SERVICE
                // ==============================

                SummaryRow(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(15.dp)
                        )
                    },
                    label = "Service Type",
                    value = "Diagnostic & Tow"
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        // ==============================
        // VIEW STATUS
        // ==============================

        Button(
            onClick = {
                // Nothing for now
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = orange
            )
        ) {

            Text(
                text = "◉  View Status",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        // ==============================
        // GO TO HOME
        // ==============================

        OutlinedButton(
            onClick = {
                navController.navigate(
                    Screen.HomeScreen.route
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp)
        ) {

            Text(
                text = "Go to Home",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}


// ==========================================
// REUSABLE SUMMARY ROW
// ==========================================

@Composable
private fun SummaryRow(
    icon: @Composable () -> Unit,
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        icon()

        Spacer(modifier = Modifier.size(7.dp))

        Text(
            text = label,
            fontSize = 11.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = value,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}