package aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels

import aleksandr.fedotkin.sellercryptomoney.core.runOnIO
import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.SellerUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val sellerUseCase: SellerUseCase
): ViewModel() {

    private val _errorMessage: MutableStateFlow<String> = MutableStateFlow(value = "")
    private val _errorState: MutableStateFlow<Boolean> = MutableStateFlow(value = false)
    private val _sellers: MutableStateFlow<List<SellerModel>> =
        MutableStateFlow(value = emptyList())
    private val _sellerIndex: MutableStateFlow<Int> = MutableStateFlow(value = 0)

    val errorMessage: StateFlow<String> = _errorMessage
    val errorState: StateFlow<Boolean> = _errorState
    val sellers: StateFlow<List<SellerModel>> = _sellers
    val sellerIndex: StateFlow<Int> = _sellerIndex

    fun close() {
        _errorState.value = false
    }

    suspend fun loadSellers() = runOnIO {
        _sellers.value = sellerUseCase.getSellers()
    }

    fun setSellerIndex(sellerIndex: Int) {
        _sellerIndex.value = sellerIndex
    }
}
