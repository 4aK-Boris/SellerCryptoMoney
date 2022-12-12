package aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels

import aleksandr.fedotkin.sellercryptomoney.core.BaseViewModel
import aleksandr.fedotkin.sellercryptomoney.core.ErrorHandler
import aleksandr.fedotkin.sellercryptomoney.core.runOnIO
import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.PurchaseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PurchaseViewModel(
    private val purchaseUseCase: PurchaseUseCase,
    errorHandler: ErrorHandler
): BaseViewModel(errorHandler = errorHandler) {

    private val _purchases: MutableStateFlow<List<PurchaseModel>> = MutableStateFlow(value = emptyList())

    val purchases: StateFlow<List<PurchaseModel>> = _purchases

    suspend fun loadPurchases(sellerId: Int) = runOnIO {
        purchaseUseCase.getPurchases(sellerId = sellerId).resultDefaultHandle {
            _purchases.value = it
        }
    }
}
