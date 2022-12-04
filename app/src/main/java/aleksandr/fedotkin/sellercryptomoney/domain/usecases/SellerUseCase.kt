package aleksandr.fedotkin.sellercryptomoney.domain.usecases

import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.SellerRepository

class SellerUseCase(
    private val sellerRepository: SellerRepository
) {

    suspend fun getSellers(): List<SellerModel> {
        return sellerRepository.getSellers()
    }
}
