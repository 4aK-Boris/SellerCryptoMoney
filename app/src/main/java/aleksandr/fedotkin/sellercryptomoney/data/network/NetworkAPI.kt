package aleksandr.fedotkin.sellercryptomoney.data.network

import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerProductDTO
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerDTO


interface NetworkAPI {
    suspend fun getSellers(): List<SellerDTO>
    suspend fun getSellerProducts(sellerId: Int): List<SellerProductDTO>
    suspend fun getSellerPurchases(sellerId: Int): List<SellerPurchaseDTO>
}
