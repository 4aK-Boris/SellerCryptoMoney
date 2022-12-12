package aleksandr.fedotkin.sellercryptomoney.domain.usecases

import aleksandr.fedotkin.sellercryptomoney.domain.common.BaseUseCase
import aleksandr.fedotkin.sellercryptomoney.domain.common.Result
import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.ProductRepository

class ProductUseCase(
    private val productRepository: ProductRepository
): BaseUseCase() {

    suspend fun getProducts(sellerId: Int): Result<List<ProductModel>> = safeCall {
       productRepository.getProducts(sellerId = sellerId)
    }
}
