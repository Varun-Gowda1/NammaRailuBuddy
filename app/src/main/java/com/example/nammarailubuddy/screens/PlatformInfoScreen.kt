package com.example.nammarailubuddy.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nammarailubuddy.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlatformInfoScreen(onBackClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(BackgroundLight)) {
        // Dark Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(PremiumNavy)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = TextLight)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("Live Tracking", color = TextLight, style = MaterialTheme.typography.titleLarge)
                        Text("Train 56205", color = TextGrey, style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(AccentGreen.copy(alpha = 0.2f))
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text("((•)) Live", color = AccentGreen, fontWeight = FontWeight.Bold)
                    }
                    Text("Medium Crowd", color = Color(0xFFF59E0B), fontWeight = FontWeight.SemiBold)
                }
            }
        }

        // Main Content Area with Timeline
        Column(modifier = Modifier.fillMaxSize().padding(top = 180.dp)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                // Background Curved Timeline Path
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val path = Path().apply {
                        moveTo(size.width * 0.3f, 0f)
                        quadraticBezierTo(size.width * 0.4f, size.height * 0.5f, size.width * 0.1f, size.height)
                    }
                    drawPath(path = path, color = NeonCyan, style = Stroke(width = 8f))
                }

                // Station Cards
                Column(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    StationCard("Bangalore City", "09:15 AM", true)
                    Box(modifier = Modifier.padding(start = 40.dp)) { StationCard("Cantonment", "09:22 AM", true) }
                    StationCard("Hebbal", "09:28 AM", false, isCurrent = true)
                    Box(modifier = Modifier.padding(start = 80.dp)) { StationCard("Banaswadi", "09:35 AM", false) }
                }
            }

            // Bottom Info Panel
            Card(
                modifier = Modifier.fillMaxWidth().shadow(16.dp, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = CardWhite)
            ) {
                Column(modifier = Modifier.padding(32.dp)) {
                    Text("Next Station", style = MaterialTheme.typography.titleMedium, color = TextDark)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
                        Column {
                            Text("Banaswadi", style = MaterialTheme.typography.displayLarge.copy(color = NeonCyan))
                            Text("Platform 3", style = MaterialTheme.typography.bodyLarge, color = TextGrey)
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text("7", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = TextDark)
                            Text("minutes", style = MaterialTheme.typography.labelMedium, color = TextGrey)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        QuickStatCard("Speed", "65 km/h", Icons.Default.Speed, NeonCyan)
                        QuickStatCard("Distance", "12 km", Icons.Default.LocationOn, AccentRed)
                    }
                }
            }
        }
    }
}

@Composable
fun StationCard(name: String, time: String, isPassed: Boolean, isCurrent: Boolean = false) {
    val bgColor = if (isCurrent) NeonCyan.copy(alpha = 0.1f) else CardWhite
    val textColor = if (isCurrent) NeonCyan else TextDark

    Row(verticalAlignment = Alignment.CenterVertically) {
        // Node
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(if (isPassed) AccentGreen else if (isCurrent) NeonCyan else TextGrey.copy(alpha = 0.3f))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = bgColor),
            modifier = Modifier.width(180.dp).shadow(if (isCurrent) 8.dp else 2.dp, RoundedCornerShape(16.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(name, style = MaterialTheme.typography.titleMedium, color = textColor)
                Spacer(modifier = Modifier.height(4.dp))
                Text(time, style = MaterialTheme.typography.labelMedium, color = TextGrey)
            }
        }
    }
}

@Composable
fun RowScope.QuickStatCard(title: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, color: Color) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundLight),
        modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(title, style = MaterialTheme.typography.labelMedium, color = TextGrey)
                Text(value, style = MaterialTheme.typography.titleMedium, color = TextDark)
            }
        }
    }
}
