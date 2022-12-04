package aleksandr.fedotkin.sellercryptomoney.data.repositories

import aleksandr.fedotkin.sellercryptomoney.data.mappers.PurchaseMapper
import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPI
import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.PurchaseRepository

class PurchaseRepositoryImpl(
    private val networkAPI: NetworkAPI,
    private val purchaseMapper: PurchaseMapper
): PurchaseRepository {

    override suspend fun getPurchases(sellerId: Int): List<PurchaseModel> {
        return networkAPI.getSellerPurchases(sellerId = sellerId).map { sellerPurchaseDTO ->
            purchaseMapper.map(sellerPurchaseDTO = sellerPurchaseDTO)
        }
    }
}
