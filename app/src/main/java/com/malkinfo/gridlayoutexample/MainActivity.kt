package com.malkinfo.gridlayoutexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.malkinfo.gridlayoutexample.model.EventDomainData
import com.malkinfo.gridlayoutexample.ui.theme.GridLayoutExampleTheme
import com.malkinfo.gridlayoutexample.view.EventGrid
import com.malkinfo.gridlayoutexample.view.EventsDataDetails

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridLayoutExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    /** ok now call fun NavigatePage*/

                    NavigatePage()

                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun NavigatePage(){

    val navHostController = rememberNavController()


    NavHost(
        navController = navHostController,
       startDestination = "events_data"
    ){
        composable("events_data"){
            EventGrid(navController = navHostController)
        }
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item"){
                    type = NavType.StringType
                }
            )
        ){navBackStackEntry ->

            navBackStackEntry?.arguments?.getString("item")?.let { json->
                val item = Gson().fromJson(json,EventDomainData::class.java)
                EventsDataDetails(data = item)

            }
        }
    }



}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridLayoutExampleTheme {
        Greeting("Android")
    }
}