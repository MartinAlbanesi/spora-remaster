package com.gg.spora.library.data

import com.gg.spora.R
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.domain.InfoCard

object FakeInfoCardModels {

    val FakeInfoCardModels = listOf<InfoCard>(

        InfoCard(
            title = "Deforestación",
            info = "Tala indiscriminada de arboles.",
            image = R.drawable.deforestacion,
            category = StageType.FOREST,
            isUnlocked = true
        ),
        InfoCard(
            title = "Smog",
            info = "Humo contaminado, usualmente creado a partir de los desechos industriales.",
            image = R.drawable.smog,
            category = StageType.FOREST
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.panel_solar,
            category = StageType.DESERT
        ),

        )
}