package aleksandr.fedotkin.sellercryptomoney.core

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.main.MainScreen
import aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels.MainViewModel
import androidx.activity.viewModels
import androidx.compose.runtime.Composable

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()
    override val baseViewModel: BaseViewModel by lazy { viewModel }

    @Composable
    override fun Content() {
        MainScreen()
    }
}
