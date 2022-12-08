package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.products

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.ProductViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun Snippets(
    viewModel: ProductViewModel = koinViewModel(),
    paddingValues: PaddingValues,
    sellerId: Int
) {

    val state = rememberLazyListState()

    LaunchedEffect(key1 = sellerId) {
        viewModel.loadProducts(sellerId = sellerId)
    }

    val products by viewModel.products.collectAsState()

    LazyColumn(
        state = state,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top),
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = paddingValues),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        itemsIndexed(items = products) { index, product ->

            Snippet(product = product)

            if (index < products.lastIndex) {
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
