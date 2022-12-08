package aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels

import aleksandr.fedotkin.sellercryptomoney.core.BaseViewModel
import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.PurchaseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PurchaseViewModel(
    private val purchaseUseCase: PurchaseUseCase
): BaseViewModel() {

    private val _purchases: MutableStateFlow<List<PurchaseModel>> = MutableStateFlow(value = emptyList())

    val purchases: StateFlow<List<PurchaseModel>> = _purchases

    suspend fun loadPurchases(sellerId: Int) {
        purchaseUseCase.getPurchases(sellerId = sellerId).resultDefaultHandle {
            _purchases.value = it
        }
    }

    override fun getErrorActionsMap(): Map<Int, () -> Unit> {
        return emptyMap()
    }
}
