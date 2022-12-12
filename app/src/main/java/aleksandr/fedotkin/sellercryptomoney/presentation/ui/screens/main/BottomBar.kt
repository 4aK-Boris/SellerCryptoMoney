package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.main

import aleksandr.fedotkin.sellercryptomoney.domain.models.SellerModel
import aleksandr.fedotkin.sellercryptomoney.presentation.ui.viewmodels.MainViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

private const val HALF = 500

@Composable
fun BottomBar(viewModel: MainViewModel = koinViewModel()) {

    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.loadSellers()
        state.scrollToItem(index = viewModel.sellerIndex.value)
    }

    val scrollIndex by remember { derivedStateOf { state.firstVisibleItemIndex } }

    LaunchedEffect(key1 = scrollIndex) {
        viewModel.setSellerIndex(sellerIndex = scrollIndex)
    }

    val sellers by viewModel.sellers.collectAsState()

    val scrollOffset by remember { derivedStateOf { state.firstVisibleItemScrollOffset } }

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray)
    ) {
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            state = state
        ) {
            items(sellers) { seller ->
                Seller(seller = seller)

                if (!state.isScrollInProgress) {
                    if (scrollOffset <= HALF) {
                        coroutineScope.scrollBasic(state, left = true)
                    } else {
                        coroutineScope.scrollBasic(state)
                    }

                    if (scrollOffset > HALF) {
                        coroutineScope.scrollBasic(state)
                    } else {
                        coroutineScope.scrollBasic(state, left = true)
                    }
                }
            }
        }
    }
}

private fun CoroutineScope.scrollBasic(listState: LazyListState, left: Boolean = false) {
    launch {
        val pos = if (left) listState.firstVisibleItemIndex else listState.firstVisibleItemIndex + 1
        listState.animateScrollToItem(pos)
    }
}

@Composable
private fun Seller(seller: SellerModel) {

    val width = LocalConfiguration.current.screenWidthDp.dp

    Row(
        modifier = Modifier.width(width = width),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CoilImage(
            imageModel = { seller.imageUrl },
            modifier = Modifier
                .height(height = 32.dp)
                .padding(start = 16.dp)
                .clip(shape = RoundedCornerShape(size = 4.dp)),
            loading = {
                CircularProgressIndicator(color = Color.Black, strokeWidth = 2.dp)
            },
            imageOptions = ImageOptions(
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            ),
        )

        AmountText(
            amount = seller.amountOfMoney,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun AmountText(amount: Int, modifier: Modifier) {
    Text(
        text = "$amount P",
        modifier = modifier,
        fontFamily = FontFamily.Cursive,
        fontSize = 18.sp,
        fontWeight = FontWeight.W600,
        fontStyle = FontStyle.Italic
    )
}
