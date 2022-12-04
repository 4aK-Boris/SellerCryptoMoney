package aleksandr.fedotkin.sellercryptomoney.data.repositories

import aleksandr.fedotkin.sellercryptomoney.data.mappers.SellerMapper
import aleksandr.fedotkin.sellercryptomoney.data.network.NetworkAPI
import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel
import aleksandr.fedotkin.sellercryptomoney.domain.repositories.SellerRepository

class SellerRepositoryImpl(
    private val networkAPI: NetworkAPI,
    private val sellerMapper: SellerMapper
): SellerRepository {

    override suspend fun getSellers(): List<SellerModel> {
        return networkAPI.getSellers().map { sellerDTO -> sellerMapper.map(sellerDTO = sellerDTO) }
    }
}
