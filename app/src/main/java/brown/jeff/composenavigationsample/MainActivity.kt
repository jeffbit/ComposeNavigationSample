package brown.jeff.composenavigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import brown.jeff.composenavigationsample.Destinations.RecipeDetail
import brown.jeff.composenavigationsample.common.*
import brown.jeff.composenavigationsample.ui.theme.ComposeNavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationSampleTheme {
                val navController = rememberNavController()
                val recipeListUiModelState = remember {
                    mutableStateOf(testRecipeListUiModel)
                }
                val recipeDetailUiModelState = remember {
                    mutableStateOf(testRecipeDetailUiModel)
                }
                MainScreen(
                    bottomNavController = navController,
                    recipeListUiModel = recipeListUiModelState.value,
                    recipeDetailUiModel = recipeDetailUiModelState.value
                )

            }
        }
    }

    @Composable
    fun MainScreen(
        bottomNavController: NavHostController,
        recipeListUiModel: RecipeListUiModel,
        recipeDetailUiModel: RecipeDetailUiModel
    ) {
        val bottomNavigationItems = listOf(
            BottomNavigationScreens.Recipes,
            BottomNavigationScreens.ShoppingList,
            BottomNavigationScreens.Settings

        )

        Scaffold(
            bottomBar = {
                AppBottomNavigation(
                    navController = bottomNavController,
                    items = bottomNavigationItems
                )
            },
            topBar = {
                TopAppBar(
                    title = {
                        BasicText(
                            text = stringResource(R.string.app_name),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )

                    }
                )
            }

        ) {
            ComposeNavigation(
                bottomNavHostController = bottomNavController,
                recipeListUiModel = recipeListUiModel,
                recipeDetailUiModel = recipeDetailUiModel
            )
        }
    }


    @Composable
    private fun AppBottomNavigation(
        navController: NavController,
        items: List<BottomNavigationScreens>
    ) {

        BottomNavigation {
            val currentRoute = currentRoute(navController)
            items.forEach { screen ->
                BottomNavigationItem(
                    selected = currentRoute == screen.route,
                    onClick = {
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = screen.route
                        )
                    },
                    alwaysShowLabel = false
                )
            }

        }
    }


    //Holds the Screens routes for us to access
    @Composable
    private fun currentRoute(navController: NavController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    }

    @Composable
    fun ComposeNavigation(
        bottomNavHostController: NavHostController,
        recipeListUiModel: RecipeListUiModel,
        recipeDetailUiModel: RecipeDetailUiModel,
    ) {
        NavHost(
            navController = bottomNavHostController,
            startDestination = BottomNavigationScreens.Recipes.route
        ) {
            composable(BottomNavigationScreens.Recipes.route) {
                RecipeCardList(
                    recipeListUiModel = recipeListUiModel,
                    navController = bottomNavHostController
                )
            }
            composable(Destinations.RecipeDetail) {
                RecipeDetail(recipeDetailUiModel = recipeDetailUiModel)
            }
            composable(BottomNavigationScreens.ShoppingList.route) {
                RecipeDetail(recipeDetailUiModel = recipeDetailUiModel.copy("Pizza Test 1"))
            }
            composable(BottomNavigationScreens.Settings.route) {
                RecipeDetail(recipeDetailUiModel = recipeDetailUiModel.copy("Pizza Test 2 "))
            }

        }
    }
}
