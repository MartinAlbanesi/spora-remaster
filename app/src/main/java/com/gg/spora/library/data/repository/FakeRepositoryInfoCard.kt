package com.gg.spora.library.data.repository

import com.gg.spora.R
import com.gg.spora.core.utils.enums.StageType
import com.gg.spora.library.data.local.entity.InfoCardEntity
import javax.inject.Inject

@Suppress("MaxLineLength")
class FakeRepositoryInfoCard @Inject constructor() {

    private val fakeInfoCardEntityModels = listOf<InfoCardEntity>(

        InfoCardEntity(
            id = "1",
            title = "Deforestación",
            info = "Tala indiscriminada de arboles.",
            image = R.drawable.deforestation.toString(),
            category = StageType.FOREST,
            isUnlocked = true
        ),
        InfoCardEntity(
            id = "2",
            title = "Composta",
            info = "La composta es cuando juntamos restos de comida, hojas y plantas secas para que se descompongan y se conviertan en tierra rica, que ayuda a las plantas a crecer fuertes. Es una forma de reciclar los desechos naturales.",
            image = R.drawable.composting.toString(),
            category = StageType.FOREST,
            isUnlocked = true
        ),
        InfoCardEntity(
            id = "3",
            title = "Smog",
            info = "Humo contaminado, usualmente creado a partir de los desechos industriales.",
            image = R.drawable.smog.toString(),
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCardEntity(
            id = "4",
            title = "Panel solar",
            info = "Utilizado en la energia renovable, aplica la energia del sol y la almacena para usos posteriores.",
            image = R.drawable.solar_panel.toString(),
            category = StageType.DESERT,
            isUnlocked = true
        ),
        InfoCardEntity(
            id = "5",
            title = "Derrame de aceite",
            info = "Un derrame de aceite en el océano crea una capa en el agua que afecta a los animales y plantas, porque impide que respiren bien y les hace daño. Limpiarlo es difícil, por eso es importante evitar estos accidentes.",
            image = R.drawable.oil_spill.toString(),
            category = StageType.LAKE,
            isUnlocked = true
        ),
        InfoCardEntity(
            id = "6",
            title = "Derrame de aceite",
            info = "Un derrame de aceite en el océano crea una capa en el agua que afecta a los animales y plantas, porque impide que respiren bien y les hace daño. Limpiarlo es difícil, por eso es importante evitar estos accidentes.",
            image = R.drawable.oil_spill.toString(),
            category = StageType.LAKE,
            isUnlocked = true
        ),

        )

    fun getAllInfoCards(): List<InfoCardEntity> {
        return fakeInfoCardEntityModels
    }
}