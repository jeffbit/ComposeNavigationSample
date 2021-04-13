package brown.jeff.composenavigationsample.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun DisplayImage(
    url: String?,
    @DrawableRes previewResource: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        if (url.isNullOrEmpty()) {
            Image(
                painter = painterResource(previewResource),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        } else {
//          Will use Glode to Display Image
        }
    }
}