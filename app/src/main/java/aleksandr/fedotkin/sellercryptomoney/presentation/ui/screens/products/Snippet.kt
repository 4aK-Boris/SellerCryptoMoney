package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.products

import aleksandr.fedotkin.sellercryptomoney.domain.models.ProductModel
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun Snippet(product: ProductModel) {

    ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {

        val (image, title, rating, quantity, price) = createRefs()

        val verticalGuideLine = createGuidelineFromStart(offset = 160.dp)

        CoilImage(
            imageModel = { product.imageUrl },
            modifier = Modifier
                .width(width = 128.dp)
                .constrainAs(ref = image) {
                    top.linkTo(anchor = parent.top, margin = 8.dp)
                    start.linkTo(anchor = parent.start, margin = 16.dp)
                },
            loading = {
                CircularProgressIndicator(color = Color.Black, strokeWidth = 4.dp)
            },
            imageOptions = ImageOptions(
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
        )

        TitleText(
            text = product.title,
            modifier = Modifier.constrainAs(ref = title) {
                top.linkTo(anchor = parent.top, margin = 8.dp)
                start.linkTo(anchor = verticalGuideLine)
                end.linkTo(anchor = parent.end, margin = 16.dp)
                width = Dimension.fillToConstraints
            })

        RatingText(
            rating = product.rating,
            modifier = Modifier.constrainAs(ref = rating) {
                top.linkTo(anchor = title.bottom, margin = 8.dp)
                start.linkTo(anchor = verticalGuideLine)
                end.linkTo(anchor = parent.end, margin = 8.dp)
                width = Dimension.fillToConstraints
            })

        QuantityText(
            quantity = product.quantity,
            modifier = Modifier.constrainAs(ref = quantity) {
                top.linkTo(anchor = rating.bottom, margin = 8.dp)
                start.linkTo(anchor = verticalGuideLine)
                end.linkTo(anchor = parent.end, margin = 8.dp)
                width = Dimension.fillToConstraints
            })

        PriceText(
            price = product.price,
            modifier = Modifier.constrainAs(ref = price) {
                bottom.linkTo(anchor = image.bottom, margin = 4.dp)
                start.linkTo(anchor = verticalGuideLine)
                end.linkTo(anchor = parent.end, margin = 8.dp)
                width = Dimension.fillToConstraints
                height = Dimension.preferredWrapContent
            })
    }
}

@Composable
private fun TitleText(text: String, modifier: Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.Serif,
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        modifier = modifier
    )
}

@Composable
private fun RatingText(rating: Double, modifier: Modifier) {
    Text(
        text = "${"%.1f".format(rating)} / 5",
        modifier = modifier,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.Cursive,
        fontSize = 14.sp,
        color = Color.Gray
    )
}

@Composable
private fun QuantityText(quantity: Int, modifier: Modifier) {
    Text(
        text = "Количество: $quantity",
        modifier = modifier,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.Serif,
        fontSize = 14.sp,
        fontWeight = FontWeight.W100,
        fontStyle = FontStyle.Italic
    )
}

@Composable
private fun PriceText(price: Int, modifier: Modifier) {
    Text(
        text = "$price P",
        modifier = modifier,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 18.sp
    )
}
