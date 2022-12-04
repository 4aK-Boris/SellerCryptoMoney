package aleksandr.fedotkin.sellercryptomoney.data.repositories

import aleksandr.fedotkin.sellercryptomoney.data.mappers.ProductMapper
import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPI
import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val networkAPI: NetworkAPI,
    private val productMapper: ProductMapper
) : ProductRepository {

    override suspend fun getProducts(sellerId: Int): List<ProductModel> {
        return networkAPI.getSellerProducts(sellerId = sellerId)
            .map { productDTO -> productMapper.map(sellerProductDTO = productDTO) }
    }
}
