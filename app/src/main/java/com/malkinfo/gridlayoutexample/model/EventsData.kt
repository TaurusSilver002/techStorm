
package com.malkinfo.gridlayoutexample.model
import com.malkinfo.gridlayoutexample.R
data  class EventDomainData(
    val id:Long,
    val title :String,
    val rating : Float,
    val desc :String,
    val imgUri:Int
)

val EventDomainList = listOf(
    EventDomainData(
        1L,
        "Brain Teasers",
        5.0f,
        "Welcome to Brain Teasers",
        R.drawable.image_1
    ),
    EventDomainData(
        2L,
        "Idea Presentation",
        5.0f,
        "Welcome to Idea Presentation",
        R.drawable.image_2
    ),
    EventDomainData(
        3L,
        "Rovers",
        5.0f,
        "Welcome to Rovers",
        R.drawable.image_3
    ),
    EventDomainData(
        4L,
        "Games",
        5.0f,
        "Welcome to Games",
        R.drawable.image_4
    ),
    EventDomainData(
        5L,
        "Creative",
        5.0f,
        "Welcome to Creative",
        R.drawable.image_5
    ),

    )