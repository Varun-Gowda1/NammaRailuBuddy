package com.example.nammarailubuddy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nammarailubuddy.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertsScreen() {
    var radius by remember { mutableStateOf(2f) }
    var isVibrationEnabled by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize().background(BackgroundLight)) {
        // Dark Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(PremiumNavy)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = TextLight)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("Destination Alarm", color = TextLight, style = MaterialTheme.typography.titleLarge)
                        Text("Never miss your stop", color = TextGrey, style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = PremiumNavyLight),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)).background(AccentGreen.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Navigation, contentDescription = null, tint = AccentGreen)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text("GPS-Based Smart Alerts", style = MaterialTheme.typography.titleMedium, color = TextLight)
                            Text("We'll wake you up before your destination", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                        }
                    }
                }
            }
        }

        // Main Card Overlapping
        Column(modifier = Modifier.fillMaxSize().padding(top = 200.dp, start = 24.dp, end = 24.dp)) {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardWhite),
                modifier = Modifier.fillMaxWidth().shadow(8.dp, RoundedCornerShape(24.dp))
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("Setup New Alarm", style = MaterialTheme.typography.titleLarge, color = TextDark)
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text("Select Destination", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Search for station...") },
                        leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null, tint = NeonCyan) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = BackgroundLight,
                            focusedBorderColor = NeonCyan,
                            containerColor = BackgroundLight
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Alert Radius", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                        Box(modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(NeonCyan.copy(alpha = 0.1f)).padding(horizontal = 8.dp, vertical = 2.dp)) {
                            Text("${radius.toInt()} km", color = NeonCyan, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Slider(
                        value = radius,
                        onValueChange = { radius = it },
                        valueRange = 0.5f..5f,
                        colors = SliderDefaults.colors(
                            thumbColor = CardWhite,
                            activeTrackColor = NeonCyan,
                            inactiveTrackColor = BackgroundLight
                        )
                    )
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("0.5 km", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                        Text("5 km", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    
                    // Glowing Target Visual
                    Box(modifier = Modifier.fillMaxWidth().height(120.dp).background(BackgroundLight, RoundedCornerShape(16.dp)), contentAlignment = Alignment.Center) {
                        Box(modifier = Modifier.size(100.dp).clip(CircleShape).background(NeonCyan.copy(alpha = 0.05f)), contentAlignment = Alignment.Center) {
                            Box(modifier = Modifier.size(70.dp).clip(CircleShape).background(NeonCyan.copy(alpha = 0.1f)), contentAlignment = Alignment.Center) {
                                Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(NeonCyan), contentAlignment = Alignment.Center) {
                                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = PremiumNavy)
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = NeonCyan)
                    ) {
                        Text("Set Alarm", color = PremiumNavy, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
