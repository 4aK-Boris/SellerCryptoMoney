package aleksandr.fedotkin.sellercryptomoney.domain.models

data class SellerModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val amountOfMoney: Int
)
