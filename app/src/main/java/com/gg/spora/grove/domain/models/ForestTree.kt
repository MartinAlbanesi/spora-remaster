package com.gg.spora.grove.domain.models

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.gg.spora.grove.data.database.entities.ForestTreeEntity
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Clase ForestTree que gestiona el crecimiento y la generación de oxígeno en un árbol del bosque
 * @param id Identificador único del árbol
 * @param type Tipo de árbol
 * @param plantingDate Fecha de plantación del árbol
 */
@SuppressLint("NewApi")
data class ForestTree(
    override val id: Int = 0,
    override val type: TreeType,
    var currentStage: GrowthStage = GrowthStage.SPROUT,
    val plantingDate: LocalDateTime = LocalDateTime.now(),
    var position: Int = 0
) : Tree(id, type) {

//  var accumulatedOxygen: Int = 0
//    private var hasReachedAdultStage = false

//    // Actualiza el estado de crecimiento del árbol
//    fun updateGrowthStage() {
//        if (!hasReachedAdultStage) {
//            var secondsGoneBy = Duration.between(plantingDate, LocalDateTime.now()).toSeconds().toInt()
//
//            Log.d("ForestTree", "Seconds gone by: $secondsGoneBy")
//
//            currentStage = when {
//                secondsGoneBy < 5 -> GrowthStage.SPROUT // 5 seconds
//                secondsGoneBy in 5..10 -> GrowthStage.MEDIUM // 5-10 seconds
//                else -> {
//                    hasReachedAdultStage = true // Set flag when reaching ADULT stage
//                    GrowthStage.ADULT // 10 seconds or more
//                }
//            }
//
//            if (currentStage == GrowthStage.ADULT) {
//                hasReachedAdultStage = true
//            }
//        }
//        Log.d("ForestTree", "Current stage: $currentStage")
//    }

    /*
    // Calcula la cantidad de oxígeno generado por el árbol
    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateGeneratedOxygen(): Int {
        updateGrowthStage()
        return if (currentStage == GrowthStage.ADULT) {
            val daysGoneBy = Duration.between(plantingDate, LocalDateTime.now()).toDays().toInt()
            accumulatedOxygen = daysGoneBy * this.type.oxygenPerDay
            accumulatedOxygen
        } else {
            0 // No generates oxygen until it becomes an adult tree
        }
    }
     */

    /*
    // Recolecta el oxígeno generado por el árbol
    @RequiresApi(Build.VERSION_CODES.O)
    fun collectOxygen(): Int {
        val oxygen = calculateGeneratedOxygen()
        accumulatedOxygen = 0
        return oxygen
    }
     */
}

fun ForestTree.toForestTreeEntity(): ForestTreeEntity {
    return ForestTreeEntity(
        idForestTree = id,
        treeType = type.name,
        currentStage = currentStage.toString(),
        plantingDate = plantingDate.toEpochSecond(ZoneOffset.UTC),
        position = position
    )
}
