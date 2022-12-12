package com.malkinfo.gridlayoutexample.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.malkinfo.gridlayoutexample.R
import com.malkinfo.gridlayoutexample.model.EventDomainData
import com.malkinfo.gridlayoutexample.ui.theme.Purple500

@Composable
fun EventsDataDetails(data:EventDomainData){

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Tech Storm 2.23",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.padding(1.dp))
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
                .clip(RoundedCornerShape(10.dp)),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = data.title,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = Color.White,
            fontSize =  20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(1.dp))

        Text(
            text = data.desc,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(6.dp),
            color = Color.White,
            fontSize =  16.sp,
            fontWeight = FontWeight.Normal,


        )
    }



}