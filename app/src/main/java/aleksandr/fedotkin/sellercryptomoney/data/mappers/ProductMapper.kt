package aleksandr.fedotkin.sellercryptomoney.data.mappers

import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerProductDTO
import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel

class ProductMapper {

    fun map(sellerProductDTO: SellerProductDTO): ProductModel {
        return ProductModel(
            id = sellerProductDTO.id,
            imageUrl = sellerProductDTO.imageUrl,
            title = sellerProductDTO.title,
            quantity = sellerProductDTO.quantity,
            rating = sellerProductDTO.rating,
            price = sellerProductDTO.price
        )
    }
}
