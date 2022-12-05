package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.main

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.navigation.Navigation
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.navigation.Screen
import aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels.MainViewModel
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {

    val sellerId by viewModel.sellerIndex.collectAsState()

    val navController = rememberNavController()

    val (state, onStateChanged) = remember { mutableStateOf(value = true) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar()
        }, floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Crossfade(targetState = state) {
                IconButton(onClick = {
                    if (it) {
                        navController.navigate(route = Screen.Purchases.route)
                    } else {
                        navController.navigate(route = Screen.Products.route)
                    }
                    onStateChanged(!state)
                }, colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                )) {
                    Icon(
                        imageVector = if (it) Icons.Default.Home else Icons.Default.Add,
                        contentDescription = "Переключатель",
                    )
                }
            }
        }) { paddingValues ->
        Navigation(
            paddingValues = paddingValues,
            sellerId = sellerId,
            navController = navController
        )
    }
}
