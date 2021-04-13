package brown.jeff.composenavigationsample.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import brown.jeff.composenavigationsample.R
import brown.jeff.composenavigationsample.common.DisplayImage
import brown.jeff.composenavigationsample.ui.theme.ComposeNavigationSampleTheme

data class RecipeCardUiModel(
    val id: Int,
    val name: String,
    val imgUrl: String,
    val isFavorite: Boolean
)

val testRecipeCardUiModel = RecipeCardUiModel(
    id = 0,
    name = "BBQ Chicken Pizza",
    imgUrl = "",
    isFavorite = false
)

@Composable
fun RecipeCard(
    uiModel: RecipeCardUiModel,
    onClick: () -> Unit = {},
) {
    Card(modifier = Modifier
        .height(294.dp)
        .clickable { onClick() }) {
        Column {
            DisplayImage(
                url = uiModel.imgUrl,
                previewResource = R.drawable.sample_pizza,
                modifier = Modifier.weight(1f)
            )
            Row {
                Text(
                    text = uiModel.name,
                    style = MaterialTheme.typography.h1.copy(fontSize = 24.sp),
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(name = "Light Recipe Card")
@Composable
fun PreviewLightRecipeCard() {
    ComposeNavigationSampleTheme() {
        RecipeCard(uiModel = testRecipeCardUiModel)
    }
}

@Preview(name = "Dark Recipe Card")
@Composable
fun PreviewDarkRecipeCard() {
    ComposeNavigationSampleTheme(darkTheme = true) {
        RecipeCard(uiModel = testRecipeCardUiModel)
    }
}
