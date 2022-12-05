package aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels

import aleksandr.fedotkin.sellercryptomoney.core.BaseViewModel
import aleksandr.fedotkin.sellercryptomoney.core.runOnIO
import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.ProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel(
    private val productUseCase: ProductUseCase
) : BaseViewModel() {

    private val _products: MutableStateFlow<List<ProductModel>> =
        MutableStateFlow(value = emptyList())

    val products: StateFlow<List<ProductModel>> = _products

    suspend fun loadProducts(sellerId: Int) = runOnIO {
        productUseCase.getProducts(sellerId = sellerId).resultDefaultHandle {
            _products.value = it
        }
    }

    override fun getErrorActionsMap(): Map<Int, () -> Unit> {
        return emptyMap()
    }
}
