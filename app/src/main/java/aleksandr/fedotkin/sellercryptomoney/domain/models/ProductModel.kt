package aleksandr.fedotkin.sellercryptomoney.domain.models

data class ProductModel(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val quantity: Int,
    val rating: Double,
    val price: Int
)
