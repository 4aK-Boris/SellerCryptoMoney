package aleksandr.fedotkin.sellercryptomoney.domain.repositories

import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel

interface SellerRepository {

    suspend fun getSellers(): List<SellerModel>
}
