package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.main

import aleksandr.fedotkin.sellercryptomoney.R
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.navigation.Navigation
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.navigation.Screen
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.MainViewModel
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {

    val sellerId by viewModel.sellerIndex.collectAsState()

    val navController = rememberNavController()

    val (state, onStateChanged) = remember { mutableStateOf(value = true) }

    Permission()

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar()
        }, floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Crossfade(targetState = state) {
                IconButton(
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    ),
                    onClick = {
                        if (it) {
                            navController.navigate(route = Screen.Purchases.route)
                        } else {
                            navController.navigate(route = Screen.Products.route)
                        }
                        onStateChanged(!state)
                    }, colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(
                        painter = painterResource(id = if (it) R.drawable.product else R.drawable.purchase),
                        contentDescription = "??????????????????????????",
                        modifier = Modifier.size(24.dp)
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

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
private fun Permission() {

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Log.d("LOG_TAG", "PERMISSION GRANTED")
        } else {
            Log.d("LOG_TAG", "PERMISSION DENIED")
        }
    }

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) -> {
                Log.d("ExampleScreen", "Code requires permission")
            }
            else -> launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}
