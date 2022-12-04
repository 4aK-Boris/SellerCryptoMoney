package aleksandr.fedotkin.sellercryptomoney.presentation.viewmodels

import aleksandr.fedotkin.sellercryptomoney.core.runOnIO
import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel
import aleksandr.fedotkin.sellercryptomoney.domain.usecases.ProductUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel(
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _products: MutableStateFlow<List<ProductModel>> =
        MutableStateFlow(value = emptyList())

    val products: StateFlow<List<ProductModel>> = _products

    suspend fun loadProducts(sellerId: Int) = runOnIO {
        _products.value = productUseCase.getProducts(sellerId = sellerId)
    }
}
