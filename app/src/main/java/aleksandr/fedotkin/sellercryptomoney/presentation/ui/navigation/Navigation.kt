package aleksandr.fedotkin.sellercryptomoney.presentation.ui.navigation

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.products.Snippets
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.purchases.Purchases
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screen.Products.route,
    paddingValues: PaddingValues,
    sellerId: Int
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Screen.Products.route,
            arguments = Screen.Products.arguments
        ) {
            Snippets(paddingValues = paddingValues, sellerId = sellerId)
        }
        composable(
            route = Screen.Purchases.route,
            arguments = Screen.Purchases.arguments
        ) {
            Purchases(paddingValues = paddingValues, sellerId = sellerId)
        }
    }
}
