package brown.jeff.composenavigationsample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPath
import androidx.navigation.NavController
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate

object Destinations {
    const val Recipes = "Recipes"
    const val RecipeList = "RecipeList"
    const val RecipeDetail = "RecipeDetail"
    const val ShoppingList = "ShoppingList"
    const val Settings = "Settings"

}


sealed class BottomNavigationScreens(val route: String, val icon: ImageVector) {
    object Recipes : BottomNavigationScreens(Destinations.Recipes, Icons.Filled.Favorite)
    object ShoppingList : BottomNavigationScreens(Destinations.ShoppingList, Icons.Filled.ShoppingCart)
    object Settings : BottomNavigationScreens(Destinations.Settings, Icons.Filled.Settings)
}

