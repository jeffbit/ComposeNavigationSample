package brown.jeff.composenavigationsample.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import brown.jeff.composenavigationsample.Destinations
import brown.jeff.composenavigationsample.ui.theme.ComposeNavigationSampleTheme


data class RecipeListUiModel(
    val recipeCardList: List<RecipeCardUiModel>
)

val testRecipeListUiModel = RecipeListUiModel(
    recipeCardList = listOf(
        testRecipeCardUiModel.copy(id = 1),
        testRecipeCardUiModel.copy(id = 2),
        testRecipeCardUiModel.copy(id = 3)
    )
)


@Composable
fun RecipeCardList(
    recipeListUiModel: RecipeListUiModel,
    navController: NavController? = null
) {

    LazyColumn(
        contentPadding = PaddingValues(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = recipeListUiModel.recipeCardList, key = { it.id }) { recipeCard ->
            RecipeCard(
                uiModel = recipeCard,
                onClick = { navController?.navigate(Destinations.RecipeDetail) })
        }
    }
}

@Preview
@Composable
fun PreviewLightRecipeList() {
    ComposeNavigationSampleTheme() {
        RecipeCardList(recipeListUiModel = testRecipeListUiModel)
    }
}

@Preview
@Composable
fun PreviewDarkRecipeList() {
    ComposeNavigationSampleTheme(darkTheme = true) {
        RecipeCardList(recipeListUiModel = testRecipeListUiModel)
    }
}
