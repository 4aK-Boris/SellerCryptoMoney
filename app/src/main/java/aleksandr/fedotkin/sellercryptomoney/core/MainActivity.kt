package aleksandr.fedotkin.sellercryptomoney.core

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.main.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.theme.SellerCryptoMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SellerCryptoMoneyTheme {
                MainScreen()
            }
        }
    }
}
