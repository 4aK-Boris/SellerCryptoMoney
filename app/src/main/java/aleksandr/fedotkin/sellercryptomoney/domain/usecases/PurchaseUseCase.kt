package aleksandr.fedotkin.sellercryptomoney.domain.usecases

import aleksandr.fedotkin.sellercryptomoney.domain.common.BaseUseCase
import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.PurchaseRepository
import aleksandr.fedotkin.sellercryptomoney.domain.common.Result

class PurchaseUseCase(
    private val purchaseRepository: PurchaseRepository
): BaseUseCase() {

    suspend fun getPurchases(sellerId: Int): Result<List<PurchaseModel>> = safeCall {
        purchaseRepository.getPurchases(sellerId = sellerId)
    }
}
