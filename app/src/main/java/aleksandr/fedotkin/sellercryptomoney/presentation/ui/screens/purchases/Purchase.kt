package aleksandr.fedotkin.sellercryptomoney.presentation.ui.screens.purchases

import aleksandr.fedotkin.sellercryptomoney.domain.models.PurchaseModel
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun Purchase(purchaseModel: PurchaseModel) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (title, buyer, price) = createRefs()

        TitleText(text = purchaseModel.titleProduct, modifier = Modifier.constrainAs(ref = title) {
            top.linkTo(anchor = parent.top, margin = 8.dp)
            start.linkTo(anchor = parent.start, margin = 32.dp)
            end.linkTo(anchor = parent.end, margin = 32.dp)
            width = Dimension.preferredWrapContent
        })

        BuyerNickNameText(
            text = purchaseModel.buyerNickName,
            modifier = Modifier.constrainAs(ref = buyer) {
                top.linkTo(anchor = title.bottom, margin = 8.dp)
                start.linkTo(anchor = parent.start, margin = 32.dp)
                end.linkTo(anchor = parent.end, margin = 32.dp)
                width = Dimension.preferredWrapContent
            })

        PriceText(
            price = purchaseModel.price,
            count = purchaseModel.count,
            modifier = Modifier.constrainAs(ref = price) {
                top.linkTo(anchor = buyer.bottom, margin = 8.dp)
                end.linkTo(anchor = parent.end, margin = 32.dp)
                width = Dimension.preferredWrapContent
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
private fun BuyerNickNameText(text: String, modifier: Modifier) {
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
private fun PriceText(price: Int, count: Int, modifier: Modifier) {
    val text = multiStyleText(
        text1 = "$price P x $count = ",
        color1 = Color.Black,
        text2 = "${price * count} P",
        color2 = Color.Green
    )
    Text(
        text = text,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.Serif,
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        modifier = modifier
    )
}

fun multiStyleText(text1: String, color1: Color, text2: String, color2: Color): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(color = color1)) {
            append(text1)
        }
        withStyle(style = SpanStyle(color = color2)) {
            append(text2)
        }
    }
}
