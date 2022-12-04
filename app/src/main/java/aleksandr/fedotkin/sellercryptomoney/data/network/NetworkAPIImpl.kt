package aleksandr.fedotkin.sellercryptomoney.data.network

import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerProductDTO
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.sellercryptomoney.data.network.ktor.KtorClient
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerDTO

class NetworkAPIImpl(private val ktorClient: KtorClient): NetworkAPI {

    override suspend fun getSellers(): List<SellerDTO> {
        return ktorClient.get(url = "/sellers")
    }

    override suspend fun getSellerProducts(sellerId: Int): List<SellerProductDTO> {
        return ktorClient.get(url = "/sellerProducts", parameters = mapOf("sellerId" to sellerId))
    }

    override suspend fun getSellerPurchases(sellerId: Int): List<SellerPurchaseDTO> {
        return ktorClient.get(url = "/sellerPurchases", parameters = mapOf("sellerId" to sellerId))
    }
}
