package com.example.nammarailubuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nammarailubuddy.components.BottomNavigationBar
import com.example.nammarailubuddy.screens.AlertsScreen
import com.example.nammarailubuddy.screens.HomeScreen
import com.example.nammarailubuddy.screens.PlatformInfoScreen
import com.example.nammarailubuddy.screens.ProfileScreen
import com.example.nammarailubuddy.ui.theme.NammaRailuBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NammaRailuBuddyTheme {
                NammaRailuBuddyApp()
            }
        }
    }
}

@Composable
fun NammaRailuBuddyApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            // Only show bottom bar on main screens
            if (currentRoute in listOf("home", "alerts", "profile")) {
                BottomNavigationBar(
                    currentRoute = currentRoute,
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(
                    onCheckPlatformClick = { navController.navigate("platform_info") }
                )
            }
            composable("alerts") {
                AlertsScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
            composable("platform_info") {
                PlatformInfoScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
