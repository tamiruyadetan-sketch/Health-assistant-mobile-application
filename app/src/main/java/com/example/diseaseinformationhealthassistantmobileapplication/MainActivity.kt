package com.example.diseaseinformationhealthassistantmobileapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.diseaseinformationhealthassistantmobileapplication.data.AppSettingsRepository
import com.example.diseaseinformationhealthassistantmobileapplication.data.BackgroundChoice
import com.example.diseaseinformationhealthassistantmobileapplication.data.UserRepository
import com.example.diseaseinformationhealthassistantmobileapplication.ui.screens.*
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.DiseaseInformationHealthAssistantMobileApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appContext = applicationContext
            var language by remember { mutableStateOf("en") }
            var darkMode by remember { mutableStateOf(AppSettingsRepository.isDarkMode(appContext)) }
            var blackBackground by remember {
                mutableStateOf(
                    AppSettingsRepository.getBackgroundChoice(appContext) == BackgroundChoice.BLACK
                )
            }
            val navController = rememberNavController()

            LaunchedEffect(Unit) { UserRepository.init(appContext) }

            DiseaseInformationHealthAssistantMobileApplicationTheme(
                darkTheme = darkMode,
                blackBackground = blackBackground
            ) {
                Scaffold(
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route

                        val showBottomBar = currentRoute != null && (
                                currentRoute == "home" || 
                                currentRoute == "categories" || 
                                currentRoute.startsWith("search") || 
                                currentRoute == "ai_assistant" || 
                                currentRoute == "settings")

                        if (showBottomBar) {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = currentRoute == "home",
                                    onClick = {
                                        navController.navigate("home") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                                    label = { Text("Home") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute == "categories",
                                    onClick = {
                                        navController.navigate("categories") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.MedicalServices, contentDescription = "Diseases") },
                                    label = { Text("Diseases") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute?.startsWith("search") == true,
                                    onClick = {
                                        navController.navigate("search") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                                    label = { Text("Search") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute == "ai_assistant",
                                    onClick = {
                                        navController.navigate("ai_assistant") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.SmartToy, contentDescription = "AI") },
                                    label = { Text("AI") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute == "settings",
                                    onClick = {
                                        navController.navigate("settings") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                                    label = { Text("Settings") }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "splash",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("splash") {
                            SplashScreen(
                                onFinished = {
                                    navController.navigate("home") {
                                        popUpTo("splash") { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable("home") {
                            HomeScreen(
                                language = language,
                                onDiseaseClick = { id -> navController.navigate("detail/$id") },
                                onLanguageClick = {
                                    language = when (language) {
                                        "en" -> "om"
                                        "om" -> "am"
                                        else -> "en"
                                    }
                                },
                                onSearchClick = { navController.navigate("search") },
                                onCategoriesClick = { navController.navigate("categories") },
                                onAiAssistantClick = { navController.navigate("ai_assistant") },
                                onFavoritesClick = { navController.navigate("favorite") }
                            )
                        }

                        composable("categories") {
                            DiseaseCategoriesScreen(
                                language = language,
                                onBack = { navController.popBackStack() },
                                onCategoryClick = { categoryName ->
                                    navController.navigate("search?query=$categoryName")
                                },
                                onLanguageClick = {
                                    language = when (language) {
                                        "en" -> "om"
                                        "om" -> "am"
                                        else -> "en"
                                    }
                                }
                            )
                        }

                        composable(
                            route = "search?query={query}",
                            arguments = listOf(navArgument("query") { defaultValue = ""; type = NavType.StringType })
                        ) { backStackEntry ->
                            val query = backStackEntry.arguments?.getString("query") ?: ""
                            SearchScreen(
                                language = language,
                                initialQuery = query,
                                onBack = { navController.popBackStack() },
                                onDiseaseClick = { id -> navController.navigate("detail/$id") },
                                onLanguageClick = {
                                    language = when (language) {
                                        "en" -> "om"
                                        "om" -> "am"
                                        else -> "en"
                                    }
                                },
                                onCategoriesClick = { navController.navigate("categories") }
                            )
                        }

                        composable(
                            route = "detail/{diseaseId}",
                            arguments = listOf(navArgument("diseaseId") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val diseaseId = backStackEntry.arguments?.getString("diseaseId")
                            if (diseaseId != null) {
                                DiseaseDetailScreen(
                                    diseaseId = diseaseId,
                                    language = language,
                                    onBack = { navController.popBackStack() },
                                    onAiAssistantClick = { navController.navigate("ai_assistant") }
                                )
                            }
                        }

                        composable("ai_assistant") {
                            AiAssistantScreen(
                                language = language,
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("favorite") {
                            FavoriteScreen(
                                language = language,
                                onDiseaseClick = { id -> navController.navigate("detail/$id") }
                            )
                        }

                        composable("settings") {
                            SettingsScreen(
                                language = language,
                                darkMode = darkMode,
                                onDarkModeChange = { enabled ->
                                    darkMode = enabled
                                    AppSettingsRepository.setDarkMode(appContext, enabled)
                                },
                                blackBackground = blackBackground,
                                onBackgroundChange = { black ->
                                    blackBackground = black
                                    AppSettingsRepository.setBackgroundChoice(
                                        appContext,
                                        if (black) BackgroundChoice.BLACK else BackgroundChoice.WHITE
                                    )
                                },
                                onLanguageChange = { newLang -> language = newLang },
                                onBack = { navController.popBackStack() },
                                onFavoritesClick = { navController.navigate("favorite") },
                                onAboutClick = { navController.navigate("about") },
                                onProfileClick = { navController.navigate("profile") },
                                onPrivacyClick = { navController.navigate("privacy") },
                                onMedicalSourcesClick = { navController.navigate("medical_sources") },
                                onDisclaimerClick = { navController.navigate("disclaimer") }
                            )
                        }

                        composable("profile") {
                            ProfileScreen(
                                language = language,
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("privacy") {
                            PrivacyPolicyScreen(onBack = { navController.popBackStack() })
                        }

                        composable("medical_sources") {
                            MedicalSourcesScreen(onBack = { navController.popBackStack() })
                        }

                        composable("disclaimer") {
                            HealthDisclaimerScreen(onBack = { navController.popBackStack() })
                        }

                        composable("about") {
                            AboutScreen()
                        }
                    }
                }
            }
        }
    }
}
