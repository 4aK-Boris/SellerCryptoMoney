package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.purchases

import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.PurchaseViewModel
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun Purchases(viewModel: PurchaseViewModel = koinViewModel(), paddingValues: PaddingValues, sellerId: Int) {

    val state = rememberLazyListState()

    LaunchedEffect(key1 = sellerId) {
        viewModel.loadPurchases(sellerId = sellerId)
    }

    val purchases by viewModel.purchases.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = paddingValues),
        state = state,
        verticalArrangement = Arrangement.Top
    ) {
        itemsIndexed(items = purchases) { index, purchase ->
            Purchase(purchaseModel = purchase)

            if (index < purchases.lastIndex) {
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
