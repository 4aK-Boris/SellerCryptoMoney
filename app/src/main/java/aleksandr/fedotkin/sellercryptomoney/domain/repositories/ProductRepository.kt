package aleksandr.fedotkin.sellercryptomoney.domain.repositories

import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel

interface ProductRepository {

    suspend fun getProducts(sellerId: Int): List<ProductModel>
}
