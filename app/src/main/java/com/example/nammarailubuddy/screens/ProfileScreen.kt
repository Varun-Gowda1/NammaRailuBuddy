package com.example.nammarailubuddy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nammarailubuddy.ui.theme.*

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(PremiumNavy, PremiumNavyLight)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("Profile", color = TextLight, style = MaterialTheme.typography.titleLarge)
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings", tint = TextGrey)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Glowing Avatar
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(NeonCyan.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(NeonCyan),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(60.dp), tint = PremiumNavy)
                }
                // Online Badge
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                    Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(PremiumNavy), contentAlignment = Alignment.Center) {
                        Box(modifier = Modifier.size(16.dp).clip(CircleShape).background(AccentGreen))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Passenger", style = MaterialTheme.typography.titleLarge, color = TextLight)
            Text("passenger@email.com", style = MaterialTheme.typography.bodyLarge, color = TextGrey)
            
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(Color(0xFFF59E0B).copy(alpha = 0.2f)).padding(horizontal = 12.dp, vertical = 6.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFF59E0B), modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Gold Member", color = Color(0xFFF59E0B), style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Stats Grid
            Row(modifier = Modifier.fillMaxWidth()) {
                StatCard(Icons.Default.Train, "42", "Total Trips", NeonCyan, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(16.dp))
                StatCard(Icons.Default.Schedule, "156", "Hours Traveled", AccentRed, Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                StatCard(Icons.Default.LocationOn, "23", "Stations Visited", AccentGreen, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(16.dp))
                StatCard(Icons.Default.StarOutline, "385", "Community Points", Color(0xFFF59E0B), Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun StatCard(icon: androidx.compose.ui.graphics.vector.ImageVector, value: String, label: String, iconColor: Color, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        modifier = modifier.height(140.dp).shadow(4.dp, RoundedCornerShape(24.dp))
    ) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.Center) {
            Box(modifier = Modifier.size(36.dp).clip(CircleShape).background(iconColor.copy(alpha = 0.1f)), contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(18.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(value, style = MaterialTheme.typography.titleLarge, color = TextDark)
            Text(label, style = MaterialTheme.typography.labelMedium, color = TextGrey)
        }
    }
}
