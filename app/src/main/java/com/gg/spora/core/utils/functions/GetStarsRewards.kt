package com.gg.spora.core.utils.functions

import com.gg.spora.R
import com.gg.spora.core.utils.SporaConstant.MAX_STAR
import com.gg.spora.core.utils.enums.StarState

/**
 * Obtiene las recompensas de las estrellas dependiendo de la cantidad de estrellas obtenidas
 * @param starsState Estado de las estrellas obtenidas
 * @param oxygenRewards Lista de recompensas de oxígeno
 * @return Devuelve un par con un map de recompensas (oxigeno y la imagen de la estrella) y el total de oxígeno obtenido
 */
fun getStarsRewards(
    starsState: StarState,
    oxygenRewards: List<Int>,
): Pair<MutableMap<Int, Int>, Int> {

    val localRewards: MutableMap<Int, Int> = mutableMapOf()

    var totalOxygen = 0

    for (i in 1..MAX_STAR) {
        if (i <= starsState.starCount) {
            localRewards[oxygenRewards[i - 1]] = R.drawable.estrella
            totalOxygen += oxygenRewards[i - 1]
        } else {
            localRewards[oxygenRewards[i - 1]] = R.drawable.estrella_gris
        }
    }

    return Pair(localRewards, totalOxygen)
}