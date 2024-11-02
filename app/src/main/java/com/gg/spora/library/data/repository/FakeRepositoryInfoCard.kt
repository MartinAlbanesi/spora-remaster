package com.gg.spora.library.data.repository

import com.gg.spora.R
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import javax.inject.Inject

class FakeRepositoryInfoCard @Inject constructor() {

    val fakeInfoCardEntityModels = listOf<InfoCardEntity>(

        InfoCardEntity(
            title = "Deforestación",
            info = "Tala indiscriminada de arboles.",
            image = R.drawable.deforestation,
            category = StageType.FOREST,
            isUnlocked = true
        ),
        InfoCardEntity(
            title = "Smog",
            info = "Humo contaminado, usualmente creado a partir de los desechos industriales.",
            image = R.drawable.smog,
            category = StageType.FOREST
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.DESERT
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.DESERT
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCardEntity(
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel,
            category = StageType.RIVER
        ),
        )

    fun getAllInfoCards(): List<InfoCardEntity> {
        return fakeInfoCardEntityModels
    }
}