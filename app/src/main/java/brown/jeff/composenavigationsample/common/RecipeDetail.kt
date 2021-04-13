package brown.jeff.composenavigationsample.common

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import brown.jeff.composenavigationsample.R
import brown.jeff.composenavigationsample.common.DisplayImage
import brown.jeff.composenavigationsample.ui.theme.ComposeNavigationSampleTheme
import java.util.*

@Composable
fun RecipeDetail(
    recipeDetailUiModel: RecipeDetailUiModel,
) {

    Column {
        DisplayImage(
            url = recipeDetailUiModel.imgUrl,
            previewResource = R.drawable.sample_pizza,
            modifier = Modifier.height(220.dp)
        )

        Header(
            title = recipeDetailUiModel.title,
        )

        Meta(type = recipeDetailUiModel.type, servingSize = recipeDetailUiModel.servingSize)

        Spacer(modifier = Modifier.height(16.dp))


    }
}


@Composable
private fun Header(
    title: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = title,
            style = MaterialTheme.typography.h1.copy(fontSize = 32.sp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        )

    }
}

@Composable
private fun Meta(type: String, servingSize: String) {
    Row(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = type, style = MaterialTheme.typography.body1)
        Divider(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(1.dp)
                .height(24.dp)
        )
        Text(text = servingSize, style = MaterialTheme.typography.body1)
    }
}


@Preview
@Composable
fun PreviewLightRecipeDetail() {
    ComposeNavigationSampleTheme() {
        RecipeDetail(recipeDetailUiModel = testRecipeDetailUiModel)
    }
}

@Preview
@Composable
fun PreviewDarkRecipeDetail() {
    ComposeNavigationSampleTheme(darkTheme = true) {
        RecipeDetail(recipeDetailUiModel = testRecipeDetailUiModel)
    }
}


data class RecipeDetailUiModel(
    val title: String,
    val type: String,
    val imgUrl: String,
    val isFavorite: Boolean,
    val servingSize: String
)


val testRecipeDetailUiModel = RecipeDetailUiModel(
    title = "BBQ Chicken Pizza",
    type = "Italian",
    imgUrl = "",
    isFavorite = false,
    servingSize = "4"
)
