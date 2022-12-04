package aleksandr.fedotkin.sellercryptomoney.domain.repositories

import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel

interface PurchaseRepository {

    suspend fun getPurchases(sellerId: Int): List<PurchaseModel>
}
