package aleksandr.fedotkin.sellercryptomoney.domain.usecases

import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.ProductRepository

class ProductUseCase(
    private val productRepository: ProductRepository
) {

    suspend fun getProducts(sellerId: Int): List<ProductModel> {
        return productRepository.getProducts(sellerId = sellerId)
    }
}
