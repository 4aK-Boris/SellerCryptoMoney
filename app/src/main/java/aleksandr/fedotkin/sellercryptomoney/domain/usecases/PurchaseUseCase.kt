package aleksandr.fedotkin.sellercryptomoney.domain.usecases

import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.PurchaseRepository

class PurchaseUseCase(
    private val purchaseRepository: PurchaseRepository
) {

    suspend fun getPurchases(sellerId: Int): List<PurchaseModel> {
        return purchaseRepository.getPurchases(sellerId = sellerId)
    }
}
