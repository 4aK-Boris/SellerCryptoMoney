package aleksandr.fedotkin.sellercryptomoney.domain.usecases

import aleksandr.fedotkin.sellercryptomoney.domain.common.BaseUseCase
import aleksandr.fedotkin.sellercryptomoney.domain.common.Result
import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.SellerRepository

class SellerUseCase(
    private val sellerRepository: SellerRepository
): BaseUseCase() {

    suspend fun getSellers(): Result<List<SellerModel>> = safeCall {
        sellerRepository.getSellers()
    }
}
