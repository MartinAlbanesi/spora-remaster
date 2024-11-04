package com.gg.spora.library.data.repository

import com.gg.spora.R
import com.gg.spora.core.utils.enums.TypeStage
import com.gg.spora.library.domain.InfoCard
import javax.inject.Inject

class FakeRepositoryInfoCard @Inject constructor() {

    val fakeInfoCardModels = listOf<InfoCard>(

        InfoCard(
            title = "Deforestación",
            info = "Tala indiscriminada de arboles.",
            image = R.drawable.deforestation,
            category = TypeStage.FOREST,
            isUnlocked = true
        ),
        InfoCard(
            title = "Smog",
            info = "Humo contaminado, usualmente creado a partir de los desechos industriales.",
            image = R.drawable.smog,
            category = TypeStage.FOREST
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.DESERT
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.DESERT
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.DESERT,
            isUnlocked = true
        ),
        InfoCard(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = TypeStage.RIVER
        ),
        )

    fun getAllInfoCards(): List<InfoCard> {
        return fakeInfoCardModels
    }
}