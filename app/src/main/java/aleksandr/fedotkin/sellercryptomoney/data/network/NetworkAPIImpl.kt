package aleksandr.fedotkin.sellercryptomoney.data.network

import aleksandr.fedotkin.sellercryptomoney.core.SELLERS
import aleksandr.fedotkin.sellercryptomoney.core.SELLERS_PRODUCTS
import aleksandr.fedotkin.sellercryptomoney.core.SELLERS_PURCHASES
import aleksandr.fedotkin.sellercryptomoney.core.SELLER_ID
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerDTO
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerProductDTO
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.KtorClient

class NetworkAPIImpl(private val ktorClient: KtorClient): NetworkAPI {

    override suspend fun getSellers(): List<SellerDTO> {
        return ktorClient.get(url = SELLERS)
    }

    override suspend fun getSellerProducts(sellerId: Int): List<SellerProductDTO> {
        return ktorClient.get(url = SELLERS_PRODUCTS, parameters = mapOf(SELLER_ID to sellerId))
    }

    override suspend fun getSellerPurchases(sellerId: Int): List<SellerPurchaseDTO> {
        return ktorClient.get(url = SELLERS_PURCHASES, parameters = mapOf(SELLER_ID to sellerId))
    }
}
