package aleksandr.fedotkin.sellercryptomoney.core

import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.Websockets
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.main.MainScreen
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.MainViewModel
import android.os.Build
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()
    override val baseViewModel: BaseViewModel by lazy { viewModel }

    private val webSockets by inject<Websockets>()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @Composable
    override fun Content() {
        MainScreen()

//        LaunchedEffect(key1 = true) {
//            webSockets.check()
//        }
    }
}
