package com.example.nammarailubuddy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nammarailubuddy.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onCheckPlatformClick: () -> Unit) {
    var search by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(BackgroundLight)) {
        // Dark Navy Header Background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(PremiumNavy)
        )

        Column(modifier = Modifier.fillMaxSize()) {
            // Header Section
            Column(modifier = Modifier.padding(24.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Good Morning,", color = TextGrey, style = MaterialTheme.typography.bodyLarge)
                        Text("Passenger", color = TextLight, style = MaterialTheme.typography.displayLarge)
                    }
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(NeonCyan),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("P", color = PremiumNavy, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = { Text("Search station, train number...", color = TextGrey) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CardWhite, RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = NeonCyan
                    )
                )
            }

            // Quick Actions Overlapping Card
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .offset(y = (-16).dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                QuickActionItem(Icons.Default.LocationOn, "Track", NeonCyan.copy(alpha = 0.1f), NeonCyan)
                QuickActionItem(Icons.Default.Train, "Coach", AccentRed.copy(alpha = 0.1f), AccentRed)
                QuickActionItem(Icons.Default.Notifications, "Alarm", AccentGreen.copy(alpha = 0.1f), AccentGreen)
                QuickActionItem(Icons.Default.People, "Updates", Color(0xFFF59E0B).copy(alpha = 0.1f), Color(0xFFF59E0B))
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Live Trains Section
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Live Trains", style = MaterialTheme.typography.titleLarge, color = TextDark)
                    Text("View All", color = NeonCyan, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = CardWhite),
                    modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(24.dp))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text("Bangalore City - Whitefield", style = MaterialTheme.typography.titleMedium, color = TextDark)
                                Text("Train No: 56205", style = MaterialTheme.typography.bodyLarge, color = TextGrey)
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(AccentGreen.copy(alpha = 0.1f))
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("On Time", color = AccentGreen, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            InfoStat("Platform", "2", Icons.Default.LocationOn, NeonCyan)
                            InfoStat("ETA", "3 mins", Icons.Default.Schedule, AccentRed)
                            InfoStat("Crowd", "Medium", Icons.Default.People, Color(0xFFF59E0B))
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        
                        Text("Crowd Level", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                        Spacer(modifier = Modifier.height(4.dp))
                        LinearProgressIndicator(
                            progress = 0.6f,
                            modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
                            color = Color(0xFFF59E0B),
                            trackColor = BackgroundLight
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = onCheckPlatformClick,
                            modifier = Modifier.fillMaxWidth().height(52.dp),
                            shape = RoundedCornerShape(26.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = NeonCyan.copy(alpha = 0.1f))
                        ) {
                            Icon(Icons.Default.Navigation, contentDescription = null, tint = NeonCyan)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Track Live", color = NeonCyan, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(100.dp)) // padding for bottom nav
        }
    }
}

@Composable
fun QuickActionItem(icon: ImageVector, label: String, bgColor: Color, iconColor: Color) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        modifier = Modifier.size(76.dp).shadow(2.dp, RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(40.dp).clip(CircleShape).background(bgColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = label, tint = iconColor, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(label, style = MaterialTheme.typography.labelMedium, color = TextDark)
        }
    }
}

@Composable
fun InfoStat(label: String, value: String, icon: ImageVector, color: Color) {
    Column {
        Text(label, style = MaterialTheme.typography.labelMedium, color = TextGrey)
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(value, style = MaterialTheme.typography.titleMedium, color = TextDark)
        }
    }
}
