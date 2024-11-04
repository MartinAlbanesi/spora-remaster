package com.gg.spora.core.fake

import com.gg.spora.challenge.domain.model.ObjectDetail
import com.gg.spora.challenge.domain.model.StepObjectDetail

object FakeChallengeModels {

    val fakeObjectDetails = listOf(
        ObjectDetail(
            "Botella de plástico",
            "Muchas botellas de plástico se pueden reciclar, y seguro que encontras varias en casa.",
            false,
            mutableListOf(
                StepObjectDetail( 1,"Botella de plástico", "Limpieza",
                "Vacíá y limpiá las botellas: enjuagalas con agua y un poquito de detergente para dejarlas listas para reciclar.",
                true, false),
                StepObjectDetail( 2,"Botella de plástico","Validación",
                    "Una botella de plástico que se puede reciclar debe tener un ícono de reciclaje. ¡Buscá el símbolo antes de desecharla!",
                    false, false),
                StepObjectDetail( 3,"Botella de plástico","Reciclado",
                    "Si la botella es reciclable, ¡podés ponerla en los contenedores de reciclaje para que tenga una nueva vida!",
                    false, false),
                StepObjectDetail(4,"Botella de plástico","Crear",
                    "Si la botella no es reciclable, ¡no te preocupes! Podés reutilizarla para hacer manualidades o crear objetos decorativos y divertidos.",
                    false, false),
                StepObjectDetail( 5,"Botella de plástico","Repite",
                    "Repite los mismos pasos de reciclaje. ¡Mientras mas botellas juntes, mas vas a ayudar al planeta",
                    false, true)
            )
        ),
        ObjectDetail(
            "Caja de cartón",
            "Al reutilizar el cartón, ¡estamos cuidando el planeta y a nuestros amigos los árboles!",
            false,
            mutableListOf(
                StepObjectDetail( 1, "Caja de cartón", "Limpieza",
                "Asegurate de que la caja de cartón esté limpia y libre de cualquier elemento que pueda interferir con su reciclaje.",true, false),
                StepObjectDetail( 2, "Caja de cartón","Recortar",
                    "Con la ayuda de un adulto, cortá la caja de cartón en pequeños trozos.",
                    false, false),
                StepObjectDetail( 3, "Caja de cartón","Crear",
                    "Con estos pequeños trozos de cartón, ¡podés crear manualidades divertidas y darle una nueva vida al cartón!",
                    false, false),
                StepObjectDetail( 4, "Caja de cartón","Repite",
                    "Repite los mismos pasos de reciclaje. ¡Mientras mas cajas de carton juntes, mas vas a ayudar al planeta",
                    false, true)
            )
        ),
        ObjectDetail(
            "Tapita de plástico",
            "Las tapitas de plástico están en todos lados, ¡y reciclarlas es muy fácil!",
            false,
            mutableListOf(
                StepObjectDetail( 1, "Tapita de plástico","Juntar",
                "Reuní tapitas plásticas de gaseosas, aguas, juegos y productos de limpieza, ¡esas son las que se pueden reciclar!",
                true, false),
                StepObjectDetail( 2, "Tapita de plástico","Limpieza",
                    "Lavá las tapitas para eliminar cualquier residuo de líquidos o suciedad que pueda afectar el reciclaje.",
                    false, false),
                StepObjectDetail( 3, "Tapita de plástico","Crear o llevar",
                    "Podés usar las tapitas para hacer decoraciones creativas o llevarlas a una planta de reciclaje. ¡Ellos sabrán qué hacer!",
                    false, false),
                StepObjectDetail( 4, "Tapita de plástico","Repite",
                    "Repite los mismos pasos de reciclaje. ¡Mientras mas tapitas juntes, mas vas a ayudar al planeta",
                    false, true)
            )
        ),
        ObjectDetail(
            "Lata de aluminio",
            "Reciclar latas de aluminio aporta importantes beneficios en el planeta y ayuda a ahorrar energía al producir materiales de aluminio con latas.",
            false,
            mutableListOf(
                StepObjectDetail( 1, "Lata de aluminio","Juntar",
                "Reuní latas de aluminio de gaseosas o jugos y asegurate que solo sean de aluminio.!",
                true, false),
                StepObjectDetail( 2, "Lata de aluminio","Limpieza",
                    "Lavá las latas con agua para quitar cualquier mugre que pueda afectar el reciclaje.",
                    false, false),
                StepObjectDetail( 3, "Lata de aluminio","Aplastar (opcional)",
                    "Con ayuda de un adulto, aplasta las latas asi podes juntar mas en una misma bolsa o lugar.",
                    false, false),
                StepObjectDetail( 4, "Lata de aluminio","Llevar",
                    "Envia las latas a un centro de reciclaje cercano para que puedan ser convertidas en nuevos productos como bicicletas o partes de autos.",
                    false, false),
                StepObjectDetail( 5, "Lata de aluminio","Repite",
                    "Repite los mismos pasos de reciclaje. ¡Mientras mas latas juntes, mas vas a ayudar al planeta",
                    false, true)
            )
        )
    )
}