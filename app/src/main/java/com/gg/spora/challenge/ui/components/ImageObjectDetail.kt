package com.gg.spora.challenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gg.spora.R


@Composable
fun ImageObjectDetail(objectDetailName : String){
    Image(
        painter = painterResource(id = classifyImageObjectDetail(objectDetailName)),
        contentDescription = "Image Object Detail",
        modifier = Modifier.size(100.dp)
    )
}

fun classifyImageObjectDetail(objectDetailName : String) : Int{

    val image : Int = when (objectDetailName) {
        "Botella de plástico" -> {
            R.drawable.plastic_bottle
        }
        "Caja de carton" -> {
            R.drawable.cardboard_box
        }
        "Tapita de plástico" -> {
            R.drawable.bottle_cap
        }
        "Lata de aluminio" -> {
            R.drawable.aluminum_can
        }
        else -> {
            0
        }
    }

    return image
}