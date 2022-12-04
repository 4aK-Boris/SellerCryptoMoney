package aleksandr.fedotkin.sellercryptomoney.domain.models

data class PurchaseModel(
    val count: Int,
    val price: Int,
    val titleProduct: String,
    val buyerNickName: String
)
