package com.malkinfo.gridlayoutexample.view

import android.content.Context
import android.graphics.PorterDuff
import android.widget.RatingBar
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.malkinfo.gridlayoutexample.R
import com.malkinfo.gridlayoutexample.model.EventDomainData
import com.malkinfo.gridlayoutexample.ui.theme.Purple500


@ExperimentalFoundationApi
@Composable

fun EventGrid(navController : NavController){

    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context,"EventList.json")
    val gson = Gson()
    val gridSampleType = object :TypeToken<List<EventDomainData>>(){}.type
    val fruitData : List<EventDomainData> = gson.fromJson(dataFileString,gridSampleType)
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Purple500)
            .padding(6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Tech Storm 2.23",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(1),
          modifier = Modifier.padding(10.dp)
        ){
            items(fruitData){data->
                EventDataGridItem(data,navController)

            }

        }

    }



}
@Composable
fun EventDataGridItem(data: EventDomainData, navController :NavController){

    Card(modifier = Modifier
        .clickable {
            val itemVal = Gson().toJson(data)
            navController.navigate("grid_detail/$itemVal")
        }
        .padding(10.dp)
        .fillMaxSize(),
        elevation =  5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier) {
            Image(painter = painterResource(
                id =  when(data.id){
                    1L-> R.drawable.image_1
                    2L -> R.drawable.image_2
                    3L -> R.drawable.image_3
                    4L -> R.drawable.image_4
                    5L -> R.drawable.image_5
                    else -> R.drawable.image_1
                }
            ),
                contentDescription = "Grid Image",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = data.title,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.padding(2.dp))
            val ratingBar = android.widget.RatingBar(
                LocalContext.current, null, R.attr.ratingBarStyleSmall
            ).apply {
                rating = 0.5f
                progressDrawable.setColorFilter(
                    android.graphics.Color.parseColor("#FF0000"),
                    PorterDuff.Mode.SRC_ATOP
                )
            }


        }

    }



}

fun getJsonDataFromAsset(context: Context, data: String):String {
    return context.assets.open(data).bufferedReader().use { it.readText() }

}
