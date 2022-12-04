package aleksandr.fedotkin.sellercryptomoney.data.dto

@kotlinx.serialization.Serializable
data class SellerProductDTO(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val quantity: Int,
    val rating: Double,
    val price: Int
)
