package aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels

import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.PurchaseUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PurchaseViewModel(
    private val purchaseUseCase: PurchaseUseCase
): ViewModel() {

    private val _purchases: MutableStateFlow<List<PurchaseModel>> = MutableStateFlow(value = emptyList())

    val purchases: StateFlow<List<PurchaseModel>> = _purchases

    suspend fun loadPurchases(sellerId: Int) {
        _purchases.value = purchaseUseCase.getPurchases(sellerId = sellerId)
    }
}
