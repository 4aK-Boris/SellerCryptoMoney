package aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels

import aleksandr.fedotkin.sellercryptomoney.core.BaseViewModel
import aleksandr.fedotkin.sellercryptomoney.core.ErrorHandler
import aleksandr.fedotkin.sellercryptomoney.core.runOnIO
import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.SellerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val sellerUseCase: SellerUseCase,
    errorHandler: ErrorHandler
): BaseViewModel(errorHandler = errorHandler) {

    private val _sellers: MutableStateFlow<List<SellerModel>> =
        MutableStateFlow(value = emptyList())
    private val _sellerIndex: MutableStateFlow<Int> = MutableStateFlow(value = 0)

    val sellers: StateFlow<List<SellerModel>> = _sellers
    val sellerIndex: StateFlow<Int> = _sellerIndex

    suspend fun loadSellers() = runOnIO {
        sellerUseCase.getSellers().resultDefaultHandle {
            _sellers.value = it
        }
    }

    fun setSellerIndex(sellerIndex: Int) {
        _sellerIndex.value = sellerIndex
    }
}
