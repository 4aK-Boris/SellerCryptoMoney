package aleksandr.fedotkin.sellercryptomoney.data.mappers

import aleksandr.fedotkin.sellercryptomoney.data.dto.SellerPurchaseDTO
import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel

class PurchaseMapper {

    fun map(sellerPurchaseDTO: SellerPurchaseDTO): PurchaseModel {
        return PurchaseModel(
            count = sellerPurchaseDTO.count,
            price = sellerPurchaseDTO.price,
            titleProduct = sellerPurchaseDTO.titleProduct,
            buyerNickName = sellerPurchaseDTO.buyerNickName
        )
    }
}
