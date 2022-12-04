package aleksandr.fedotkin.sellercryptomoney.data.mappers

import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerDTO
import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel

class SellerMapper {

    fun map(sellerDTO: SellerDTO): SellerModel {
        return SellerModel(
            id = sellerDTO.id,
            imageUrl = sellerDTO.imageUrl,
            title = sellerDTO.title,
            amountOfMoney = sellerDTO.amountOfMoney
        )
    }
}
