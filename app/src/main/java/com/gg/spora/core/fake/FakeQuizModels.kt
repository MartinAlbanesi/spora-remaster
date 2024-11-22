package com.gg.spora.core.fake

import com.gg.spora.core.utils.enums.TypeGame
import com.gg.spora.core.utils.enums.TypeQuestion
import com.gg.spora.miniGames.domain.model.Answer
import com.gg.spora.miniGames.domain.model.Question
import kotlin.collections.listOf

@Suppress("LargeClass", "LongParameterList")
object FakeQuizModels {
    // ----------------------- NEW QUIZ -----------------------

    val newFakeAnswers = listOf(
        Answer(
            "0", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "1", "Restos de comida", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "2", "Pañales", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "3", "Ropa usada", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        //QUIZ 1
        Answer(
            "4", "Usar más el auto", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "5", "Comer solo comida rápida", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "6", "Caminar o usar bicicleta", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "7", "Comprar más cosas nuevas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        //QUIZ 2
        Answer(
            "8", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "9", "Vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "10", "Papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "11", "Aluminio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "12", "Oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "13", "Nitrógeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "14", "Dióxido de carbono", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "15", "Helio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "16", "Lavar el auto todos los dias", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "17",
            "Cerrar la canilla al cepillarse los dientes",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "18", "Usar más agua en la ducha", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "19", "Lavar la ropa a mano", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "20", "Frutas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "21", "Hojas secas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "22", "Bolsas de plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "23", "Flores", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "24", "Gatos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "25", "Perros", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "26", "Peces", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "27", "Conejos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "28", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "29", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "30", "Energía solar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "31", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "32", "Tirarla a la basura", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "33", "Donarla o reciclarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "34", "Quemarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "35", "Guardarla sin usar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "36", "Usar bolsas de tela", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "37",
            "Comprar productos empaquetados",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "38",
            "Elegir envases de un solo uso",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "39", "Comer con platos desechables", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "40", "Electricidad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "41", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "42", "Agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "43", "Carbono", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "44", "Aumenta la humedad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "45", "Genera más oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "46", "Elimina la contaminación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "47", "Reduce el calor del invierno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "48", "Aumento de lluvias", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "49", "Sequias", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "50", "Aumento del alimento", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "51",
            "Disminución del nivel del mar",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "52", "Energía solar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "53", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "54", "Gasolina", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "55", "Biocombustible", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "56", "Panda", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "57", "Oso polar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "58", "Elefante", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "59", "Águila", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "60", "Reutilizar/Manualidades", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "61", "Desecharla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "62", "Quemarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "63", "Enterrarlo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "64", "Reciclarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "65", "Romperla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "66", "Enterrarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "67", "Quemarla", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "68", "Aumenta la erosión", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "69",
            "Disminuye la calidad del aire",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "70", "Más sombra/oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "71", "Reduce el espacio de juego", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "72", "De vidrio reutilizable", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "73", "De plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "74", "Bolsa de plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "75", "Bolsa de papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "76", "Cáscara de banana", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "77", "Bolsa de plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "78", "Papel de oficina", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "79", "Tela de algodón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "80", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "81", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "82", "Agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "83", "Electricidad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "84", "Emisiones de CO2", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "85", "Descomposición de alimentos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "86", "Cosecha de plantas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "87", "Construcción de casas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "88", "Evitar tirar basura", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "89", "Usar detergentes fuertes", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "90", "Lavar ropa", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "91", "Quemar desechos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "92", "Reciclarlos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "93", "Desecharlos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "94", "Guardarlos y no usarlos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "95", "Tirarlos en la calle", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "96", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "97", "Hojas secas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "98", "Papel usado", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "99", "Cáscaras de frutas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "100", "Energía eólica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "101", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "102", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "103", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "104", "Plantar arboles", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "105", "Usar cárbon al cocinar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "106", "Encender más luces", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "107", "Usar más plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "108", "Usar bombillas LED", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "109", "Usar más plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "110", "Comprar electrodomésticos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "111", "Cocinar con carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "112", "Mejora la calidad del agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "113", "Afectan a los seres vivos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "114",
            "Aumentan la cantidad de plantas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ
        ),
        Answer(
            "115", "Crean más oxígeno", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "116", "Disminuye la contaminación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "117", "Aumenta la contaminación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "118", "Reduce el uso de agua", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "119", "Se pierde energía", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ
        ),
        Answer(
            "120", "Huracán", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "121", "Tormenta de nieve", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "122",
            "Deshielo de un glaciar",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "123", "Volcán en erupción", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "124", "Panel solar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "125", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "126", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "127", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "128",
            "Usar transporte público",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "129", "Viajar en avión", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "130", "Conducir un coche", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "131", "Comprar ropa", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "132", "Papel reciclado", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "133", "Basura orgánica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "134", "Latas de aluminio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "135", "Contenedor de vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "136", "Paneles solares", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "137", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "138", "Gas natural", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "139", "Carbón", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "140",
            "Usar aspersores de jardín",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "141", "Lavar el auto", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "142",
            "Recolectar agua de lluvia",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "143", "Regar el cesped", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "144",
            "Contaminación en el aire",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "145",
            "Contaminación lumínica",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "146",
            "Contaminación del agua",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "147",
            "Contaminación acústica",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "148", "Selva tropical", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "149", "Desierto árido", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "150", "Tundra", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "151", "Sabana africana", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "152", "Oso polar", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "153", "Tigre de bengala", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "154", "Elefante africano", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "155", "Lobo gris", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "156", "Deshechar plásticos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "157",
            "Recolección de basura plástica",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "158", "Pesca industrial", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "159",
            "Instalación de rompeolas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "160",
            "Agricultura de monocultivo",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "161", "Agricultura vertical", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "162", "Uso de pesticidas", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "163",
            "Agricultura de tala y quema",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "164", "Incendios forestales", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "165",
            "Huracanes más intensos",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "166", "Erosión del suelo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "167", "Desertificación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "168", "Selva amazónica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "169", "Desierto del Sahara", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "170", "Tundra ártica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "171", "Sabana africana", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "172", "Bosques", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "173", "Ríos", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "174", "Petróleo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "175", "Minerales", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "176", "Riego por aspersión", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "177", "Riego por goteo", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "178",
            "Uso de agua reciclada",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "179",
            "Limpieza de pozos de agua",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "180", "Oso gris", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "181", "Ballena azul", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "182", "Rinoceronte negro", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "183", "Tucan", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "184", "Parque en la ciudad", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "185",
            "Rascacielos de oficinas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "186", "Estación de metro", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "187",
            "Calle con tráfico pesado",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "188", "Energía eólica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "189", "Energía de biomasa", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "190", "Energía nuclear", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "191", "Energía hidráulica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "192",
            "Construcción de represas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "193", "Pesca industrial", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "194",
            "Extracción de petróleo",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "195",
            "Construcción de viviendas",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "196", "Inundación", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "197", "Erupción volcánica", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "198",
            "Deslizamiento de tierra",
            null,
            listOf(TypeQuestion.RECYCLE),
            TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "199", "Tormenta de nieve", null, listOf(TypeQuestion.RECYCLE), TypeGame.QUIZ_IMAGE,
        ),
        Answer(
            "200", "Energía solar", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "201", "Energía eólica", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "202", "Hidroeléctrica", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "203", "Carbón", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "204", "Gas natural", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "205", "Petróleo", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "206", "Smog", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "207",
            "Derrames de petróleo",
            null,
            listOf(TypeQuestion.CONTAMINATION),
            TypeGame.RELATIONS,
        ),
        Answer(
            "208",
            "Residuos plásticos",
            null,
            listOf(TypeQuestion.CONTAMINATION),
            TypeGame.RELATIONS,
        ),
        Answer(
            "209", "Energía eólica", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "210", "Reforestación", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "211", "Paneles solares", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "212",
            "Derretimiento de glaciares",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "213",
            "Subida del nivel del mar",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "214",
            "Sequías extremas",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "215", "Reciclaje", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "216",
            "Conservación de energía",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "217",
            "Jardines verticales",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "218", "Deforestación", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "219",
            "Especies en peligro",
            null,
            listOf(TypeQuestion.BIODIVERSITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "220",
            "Ecosistemas marinos",
            null,
            listOf(TypeQuestion.BIODIVERSITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "221", "Carreteras", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "222", "Minas de carbón", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "223", "Zonas urbanas", null, listOf(TypeQuestion.BIODIVERSITY), TypeGame.RELATIONS,
        ),
        Answer(
            "224", "Reutilización", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "225", "Reciclaje", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "226",
            "Reducción de residuos",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "227",
            "Producción masiva",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "228",
            "Desechos industriales",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "229",
            "Consumo desmedido",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "230",
            "Rotación de cultivos",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "231",
            "Uso de pesticidas",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "232",
            "Conservación del suelo",
            null,
            listOf(TypeQuestion.SUSTENTABILITY),
            TypeGame.RELATIONS,
        ),
        Answer(
            "233", "Monocultivo", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "234", "Compostaje", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "235", "Deforestación", null, listOf(TypeQuestion.SUSTENTABILITY), TypeGame.RELATIONS,
        ),
        Answer(
            "236",
            "Uso de energía limpia",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "237", "Reforestación", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "238", "Reciclaje", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "239", "Uso de carbón", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "240",
            "Desperdicio de alimentos",
            null,
            listOf(TypeQuestion.CLIMATE_CHANGE),
            TypeGame.RELATIONS,
        ),
        Answer(
            "241", "Tala masiva", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "242", "Sol", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "243", "Viento", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "244", "Agua", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "245", "Gas natural", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "246", "Petróleo", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "247", "Carbón", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "248",
            "Emisiones de vehículos",
            null,
            listOf(TypeQuestion.CONTAMINATION),
            TypeGame.RELATIONS,
        ),
        Answer(
            "249", "Fábricas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "250", "Quema de basura", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "251", "Paneles solares", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "252", "Turbinas eólicas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "253", "Cultivo orgánico", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "254", "Carbón", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "255", "Petróleo", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "256", "Gas natural", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "257", "Viento", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "258", "Sol", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "259", "Agua", null, listOf(TypeQuestion.ENERGY), TypeGame.RELATIONS,
        ),
        Answer(
            "260", "Papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "261", "Vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "262", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "263", "Comida", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "264", "Hojas secas", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "265", "Piedras", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "266",
            "Derrames de petróleo",
            null,
            listOf(TypeQuestion.CONTAMINATION),
            TypeGame.RELATIONS,
        ),
        Answer(
            "267", "Pesticidas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "268", "Plásticos", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "269", "Peces", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "270", "Algas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "271", "Rocas", null, listOf(TypeQuestion.CONTAMINATION), TypeGame.RELATIONS,
        ),
        Answer(
            "272", "CO2", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "273", "Metano", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "274", "Óxido nitroso", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "275", "Oxígeno", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "276", "Hidrógeno", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "277", "Nitrógeno", null, listOf(TypeQuestion.CLIMATE_CHANGE), TypeGame.RELATIONS,
        ),
        Answer(
            "278", "Cáscaras de frutas", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "279", "Papel", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "280", "Madera", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "281", "Plástico", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "282", "Metal", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
        Answer(
            "283", "Vidrio", null, listOf(TypeQuestion.RECYCLE), TypeGame.RELATIONS,
        ),
    )


    val newFakeQuizQuestions = listOf(
        Question(
            id = "1",
            question = "¿Cuál de estos materiales es reciclable?",
            answers = listOf(newFakeAnswers[1], newFakeAnswers[2], newFakeAnswers[3]),
            correctAnswer = newFakeAnswers[0].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "2",
            question = "¿Qué debemos hacer para reducir nuestra huella de carbono?",
            answers = listOf(newFakeAnswers[4], newFakeAnswers[6], newFakeAnswers[7]),
            correctAnswer = newFakeAnswers[5].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "3",
            question = "¿Cuál de estos materiales es biodegradable?",
            answers = listOf(newFakeAnswers[8], newFakeAnswers[9], newFakeAnswers[11]),
            correctAnswer = newFakeAnswers[10].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "4",
            question = "¿Qué gas atrapa el calor en la atmósfera y contribuye al cambio climático?",
            answers = listOf(newFakeAnswers[12], newFakeAnswers[13], newFakeAnswers[15]),
            correctAnswer = newFakeAnswers[14].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "5",
            question = "¿Cuál es una buena práctica para ahorrar agua?",
            answers = listOf(newFakeAnswers[16], newFakeAnswers[18], newFakeAnswers[19]),
            correctAnswer = newFakeAnswers[17].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "6",
            question = "¿Cuál de estos objetos no debería tirarse en el suelo?",
            answers = listOf(newFakeAnswers[20], newFakeAnswers[21], newFakeAnswers[23]),
            correctAnswer = newFakeAnswers[22].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "7",
            question = "¿Qué animal se ve afectado por la contaminación del océano?",
            answers = listOf(newFakeAnswers[24], newFakeAnswers[25], newFakeAnswers[27]),
            correctAnswer = newFakeAnswers[26].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "8",
            question = "¿Cuál es una fuente de energía renovable?",
            answers = listOf(newFakeAnswers[28], newFakeAnswers[29], newFakeAnswers[31]),
            correctAnswer = newFakeAnswers[30].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "9",
            question = "¿Qué podemos hacer con la ropa que ya no usamos?",
            answers = listOf(newFakeAnswers[32], newFakeAnswers[34], newFakeAnswers[35]),
            correctAnswer = newFakeAnswers[33].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "10",
            question = "¿Qué podemos hacer para reducir el uso de plástico?",
            answers = listOf(newFakeAnswers[37], newFakeAnswers[38], newFakeAnswers[39]),
            correctAnswer = newFakeAnswers[36].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "11",
            question = "¿Qué recurso natural ahorramos al apagar las luces cuando no son necesarias?",
            answers = listOf(newFakeAnswers[41], newFakeAnswers[42], newFakeAnswers[43]),
            correctAnswer = newFakeAnswers[40].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "12",
            question = "¿Cuál es un beneficio de plantar árboles en las ciudades?",
            answers = listOf(newFakeAnswers[44], newFakeAnswers[46], newFakeAnswers[47]),
            correctAnswer = newFakeAnswers[45].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "13",
            question = "¿Cuál de estos es un problema causado por el cambio climático?",
            answers = listOf(newFakeAnswers[48], newFakeAnswers[50], newFakeAnswers[51]),
            correctAnswer = newFakeAnswers[49].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "14",
            question = "¿Qué tipo de energía no contamina el aire cuando se usa?",
            answers = listOf(newFakeAnswers[53], newFakeAnswers[54], newFakeAnswers[55]),
            correctAnswer = newFakeAnswers[52].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "15",
            question = "¿Cuál de estos animales está en peligro debido a la deforestación de los bosques tropicales?",
            answers = listOf(newFakeAnswers[57], newFakeAnswers[58], newFakeAnswers[59]),
            correctAnswer = newFakeAnswers[56].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "16",
            question = "¿Qué podemos hacer con una botella de plástico vacía en casa para ayudar al medio ambiente?",
            answers = listOf(newFakeAnswers[61], newFakeAnswers[62], newFakeAnswers[63]),
            correctAnswer = newFakeAnswers[60].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "17",
            question = "¿Qué debemos hacer con una botella de vidrio usada en lugar de tirarla a la basura?",
            answers = listOf(newFakeAnswers[65], newFakeAnswers[66], newFakeAnswers[67]),
            correctAnswer = newFakeAnswers[64].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "18",
            question = "¿Qué efecto tiene plantar más árboles en las ciudades?",
            answers = listOf(newFakeAnswers[68], newFakeAnswers[69], newFakeAnswers[71]),
            correctAnswer = newFakeAnswers[70].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "19",
            question = "¿Qué tipo de envases es mejor para el medio ambiente al hacer compras?",
            answers = listOf(newFakeAnswers[73], newFakeAnswers[74], newFakeAnswers[75]),
            correctAnswer = newFakeAnswers[72].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),

        Question(
            id = "20",
            question = "¿Cuál de estos productos tarda más en descomponerse si se deja en la naturaleza?",
            answers = listOf(newFakeAnswers[76], newFakeAnswers[78], newFakeAnswers[79]),
            correctAnswer = newFakeAnswers[77].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "21",
            question = "¿Qué recurso natural podemos ayudar a conservar al reparar fugas de agua en casa rápidamente?",
            answers = listOf(newFakeAnswers[80], newFakeAnswers[81], newFakeAnswers[83]),
            correctAnswer = newFakeAnswers[82].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "22",
            question = "¿Cuál es una de las principales fuentes de contaminación del aire?",
            answers = listOf(newFakeAnswers[85], newFakeAnswers[86], newFakeAnswers[87]),
            correctAnswer = newFakeAnswers[84].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "23",
            question = "¿Qué acción ayuda a reducir la contaminación del agua?",
            answers = listOf(newFakeAnswers[89], newFakeAnswers[90], newFakeAnswers[91]),
            correctAnswer = newFakeAnswers[88].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "24",
            question = "¿Qué debemos hacer con los residuos electrónicos, como celulares viejos?",
            answers = listOf(newFakeAnswers[93], newFakeAnswers[94], newFakeAnswers[95]),
            correctAnswer = newFakeAnswers[92].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "25",
            question = "¿Cuál de estos productos causa mayor contaminación si se quema al aire libre?",
            answers = listOf(newFakeAnswers[97], newFakeAnswers[98], newFakeAnswers[99]),
            correctAnswer = newFakeAnswers[96].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "26",
            question = "¿Cuál es una forma de energía que no emite gases contaminantes?",
            answers = listOf(newFakeAnswers[101], newFakeAnswers[102], newFakeAnswers[103]),
            correctAnswer = newFakeAnswers[100].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "27",
            question = "¿Qué acción contribuye a reducir la contaminación del aire en las ciudades?",
            answers = listOf(newFakeAnswers[105], newFakeAnswers[106], newFakeAnswers[107]),
            correctAnswer = newFakeAnswers[104].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "28",
            question = "¿Cuál es una forma de reducir la huella de carbono en los hogares?",
            answers = listOf(newFakeAnswers[109], newFakeAnswers[110], newFakeAnswers[111]),
            correctAnswer = newFakeAnswers[108].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "29",
            question = "¿Qué efecto tienen los productos químicos en el ecosistema de un lago?",
            answers = listOf(newFakeAnswers[112], newFakeAnswers[114], newFakeAnswers[115]),
            correctAnswer = newFakeAnswers[113].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "30",
            question = "¿Qué se logra al reducir el consumo de electricidad en los hogares?",
            answers = listOf(newFakeAnswers[117], newFakeAnswers[118], newFakeAnswers[119]),
            correctAnswer = newFakeAnswers[116].id,
            typeGame = TypeGame.QUIZ,
            typeQuestion = listOf(TypeQuestion.RECYCLE)
        ),
        Question(
            id = "111",
            question = "¿Qué está representado en esta imagen como ejemplo de cambio climático?",
            answers = listOf(newFakeAnswers[120], newFakeAnswers[121], newFakeAnswers[123]),
            correctAnswer = newFakeAnswers[122].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F1_quiz_image.png?alt=media&token=2189b80d-2532-46ba-8720-f9a4fbf6d09d"
        ),
        Question(
            id = "112",
            question = "¿Cuál de estos es un ejemplo de energía renovable en la imagen?",
            answers = listOf(newFakeAnswers[125], newFakeAnswers[126], newFakeAnswers[127]),
            correctAnswer = newFakeAnswers[124].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F2_quiz_image.png?alt=media&token=453fbd0e-cb79-4399-9dfa-eb10063e5d75"
        ),
        Question(
            id = "113",
            question = "¿Qué acción está representada en la imagen para reducir la huella de carbono?",
            answers = listOf(newFakeAnswers[129], newFakeAnswers[130], newFakeAnswers[131]),
            correctAnswer = newFakeAnswers[128].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F3_quiz_image.png?alt=media&token=eddcba94-0c69-4972-aea9-fb932bb5ada9"
        ),
        Question(
            id = "114",
            question = "¿Qué está representado en esta imagen como ejemplo de reciclaje?",
            answers = listOf(newFakeAnswers[133], newFakeAnswers[134], newFakeAnswers[135]),
            correctAnswer = newFakeAnswers[132].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F4_quiz_image.png?alt=media&token=8a0cd511-61b2-49be-8e60-0ed0e9fb07e5"
        ),
        Question(
            id = "115",
            question = "¿Qué está representado en esta imagen como ejemplo de energía renovable?",
            answers = listOf(newFakeAnswers[137], newFakeAnswers[138], newFakeAnswers[139]),
            correctAnswer = newFakeAnswers[136].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F5_quiz_image.png?alt=media&token=4488cb59-d06b-4498-915c-81c05c8baada"
        ),
        Question(
            id = "116",
            question = "¿Qué práctica se ilustra en la imagen como una forma de ahorro de agua?",
            answers = listOf(newFakeAnswers[140], newFakeAnswers[141], newFakeAnswers[143]),
            correctAnswer = newFakeAnswers[142].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F6_quiz_image.png?alt=media&token=236709ad-e6e7-48ed-b659-8ca39c22b86f"
        ),
        Question(
            id = "117",
            question = "¿Qué tipo de contaminación está ilustrado en esta imagen?",
            answers = listOf(newFakeAnswers[144], newFakeAnswers[146], newFakeAnswers[147]),
            correctAnswer = newFakeAnswers[145].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F7_quiz_image.png?alt=media&token=8fdcb32e-866a-43fe-8e45-8a2948a509b7"
        ),
        Question(
            id = "118",
            question = "¿Qué ecosistema está representado en esta imagen y que es crucial para la biodiversidad?",
            answers = listOf(newFakeAnswers[149], newFakeAnswers[150], newFakeAnswers[151]),
            correctAnswer = newFakeAnswers[148].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F8_quiz_image.png?alt=media&token=2b1e4980-dde7-4c7a-ab98-a1ec7b395ffc"
        ),
        Question(
            id = "119",
            question = "¿Qué animal en extinción vive en este ambiente?",
            answers = listOf(newFakeAnswers[153], newFakeAnswers[154], newFakeAnswers[155]),
            correctAnswer = newFakeAnswers[152].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F9_quiz_image.png?alt=media&token=a4084616-01e7-488e-9391-fed7844cdd96"
        ),
        Question(
            id = "1110",
            question = "¿Qué acción representa esta imagen en la lucha contra la contaminación de los océanos?",
            answers = listOf(newFakeAnswers[156], newFakeAnswers[158], newFakeAnswers[159]),
            correctAnswer = newFakeAnswers[157].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F10_quiz_image.png?alt=media&token=652021df-ae3c-4d4c-a551-7d8fc0aa7567"
        ),
        Question(
            id = "1111",
            question = "¿Qué método agrícola está representado en la imagen para reducir el impacto ambiental?",
            answers = listOf(newFakeAnswers[160], newFakeAnswers[162], newFakeAnswers[163]),
            correctAnswer = newFakeAnswers[161].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F11_quiz_image.png?alt=media&token=e23d9e0e-bdb3-4709-8718-29b5073c82c1"
        ),
        Question(
            id = "1112",
            question = "¿Qué fenómeno ambiental está ilustrado en esta imagen como un impacto del cambio climático?",
            answers = listOf(newFakeAnswers[164], newFakeAnswers[166], newFakeAnswers[167]),
            correctAnswer = newFakeAnswers[165].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F12_quiz_image.png?alt=media&token=a8ffbbf7-9a23-406a-96f0-fc6ff53bc861"
        ),
        Question(
            id = "1113",
            question = "¿Qué ecosistema se muestra en la imagen y es crucial para el equilibrio climático global?",
            answers = listOf(newFakeAnswers[168], newFakeAnswers[169], newFakeAnswers[171]),
            correctAnswer = newFakeAnswers[170].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F13_quiz_image.png?alt=media&token=cadd73f2-c3ce-42d4-ba6c-2812bc77a5e7"
        ),
        Question(
            id = "1114",
            question = "¿Qué recurso natural está en riesgo, según lo ilustrado en esta imagen?",
            answers = listOf(newFakeAnswers[173], newFakeAnswers[174], newFakeAnswers[175]),
            correctAnswer = newFakeAnswers[172].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F14_quiz_image.png?alt=media&token=fe98c17f-1acf-4d91-a262-e589d4d849e8"
        ),
        Question(
            id = "1115",
            question = "¿Qué medida de conservación de agua está representada en esta imagen?",
            answers = listOf(newFakeAnswers[176], newFakeAnswers[178], newFakeAnswers[179]),
            correctAnswer = newFakeAnswers[177].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F15_quiz_image.png?alt=media&token=18f6f299-f9c0-44bb-a27e-84af05468c1e"
        ),
        Question(
            id = "1116",
            question = "¿Qué animal vive en esta zona del África y está en peligro de extinción?",
            answers = listOf(newFakeAnswers[180], newFakeAnswers[181], newFakeAnswers[183]),
            correctAnswer = newFakeAnswers[182].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F16_quiz_image.png?alt=media&token=3101ed4f-91a4-495f-8b6d-8097a8c57cfb"
        ),
        Question(
            id = "1117",
            question = "¿Qué tipo de paisaje urbano está representado en la imagen como ejemplo de infraestructura verde?",
            answers = listOf(newFakeAnswers[185], newFakeAnswers[186], newFakeAnswers[187]),
            correctAnswer = newFakeAnswers[184].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F17_quiz_image.png?alt=media&token=e0e30775-6cde-40e8-9192-31cce05dd8ea"
        ),
        Question(
            id = "1118",
            question = "¿Qué tipo de energía renovable se muestra en esta imagen como alternativa a los combustibles fósiles?",
            answers = listOf(newFakeAnswers[188], newFakeAnswers[189], newFakeAnswers[190]),
            correctAnswer = newFakeAnswers[191].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F18_quiz_image.png?alt=media&token=e77a97b7-a26d-4390-960a-048f20503537"
        ),
        Question(
            id = "1119",
            question = "¿Qué actividad humana que afecta los ecosistemas costeros está representada en la imagen?",
            answers = listOf(newFakeAnswers[192], newFakeAnswers[194], newFakeAnswers[195]),
            correctAnswer = newFakeAnswers[193].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F19_quiz_image.png?alt=media&token=f4c523bd-4600-4f4f-926d-6453fff0950d"
        ),
        Question(
            id = "1120",
            question = "¿Qué evento extremo relacionado con el cambio climático se muestra en la imagen, afectando cada vez más regiones?",
            answers = listOf(newFakeAnswers[197], newFakeAnswers[198], newFakeAnswers[199]),
            correctAnswer = newFakeAnswers[196].id,
            typeGame = TypeGame.QUIZ_IMAGE,
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            image = "https://firebasestorage.googleapis.com/v0/b/spora-3f595.firebasestorage.app/o/minigames%2F20_quiz_image.png?alt=media&token=52cddaaf-c18f-4d87-ae89-68c1bdc76999"
        ),
        //---------------------------RELATION QUESTION-------------------------------
        Question(
            id = "1121",
            question = "Energías Renovables",
            answers = listOf(newFakeAnswers[200], newFakeAnswers[201], newFakeAnswers[202], newFakeAnswers[203], newFakeAnswers[205], newFakeAnswers[205]).shuffled(),
            correctAnswer = "${newFakeAnswers[200].id},${newFakeAnswers[201].id},${newFakeAnswers[202].id}",
            typeQuestion = listOf(TypeQuestion.ENERGY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1122",
            question = "Contaminación",
            answers = listOf(newFakeAnswers[206], newFakeAnswers[207], newFakeAnswers[208], newFakeAnswers[209], newFakeAnswers[210], newFakeAnswers[211]).shuffled(),
            correctAnswer = "${newFakeAnswers[206].id},${newFakeAnswers[207].id},${newFakeAnswers[208].id}",
            typeQuestion = listOf(TypeQuestion.CONTAMINATION),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1123",
            question = "Cambio climático",
            answers = listOf(newFakeAnswers[212], newFakeAnswers[213], newFakeAnswers[214], newFakeAnswers[215], newFakeAnswers[216], newFakeAnswers[217]).shuffled(),
            correctAnswer = "${newFakeAnswers[212].id},${newFakeAnswers[213].id},${newFakeAnswers[214].id}",
            typeQuestion = listOf(TypeQuestion.CLIMATE_CHANGE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1124",
            question = "Biodiversidad",
            answers = listOf(newFakeAnswers[218], newFakeAnswers[219], newFakeAnswers[220], newFakeAnswers[221], newFakeAnswers[222], newFakeAnswers[223]).shuffled(),
            correctAnswer = "${newFakeAnswers[218].id},${newFakeAnswers[219].id},${newFakeAnswers[220].id}",
            typeQuestion = listOf(TypeQuestion.BIODIVERSITY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1125",
            question = "Economía circular",
            answers = listOf(newFakeAnswers[224], newFakeAnswers[225], newFakeAnswers[226], newFakeAnswers[227], newFakeAnswers[228], newFakeAnswers[229]).shuffled(),
            correctAnswer = "${newFakeAnswers[224].id},${newFakeAnswers[225].id},${newFakeAnswers[226].id}",
            typeQuestion = listOf(TypeQuestion.SUSTENTABILITY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1126",
            question = "Agricultura sustentable",
            answers = listOf(newFakeAnswers[230], newFakeAnswers[231], newFakeAnswers[232], newFakeAnswers[233], newFakeAnswers[234], newFakeAnswers[235]).shuffled(),
            correctAnswer = "${newFakeAnswers[230].id},${newFakeAnswers[232].id},${newFakeAnswers[234].id}",
            typeQuestion = listOf(TypeQuestion.SUSTENTABILITY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1127",
            question = "Reduccion Calentamiento global",
            answers = listOf(newFakeAnswers[236], newFakeAnswers[237], newFakeAnswers[238], newFakeAnswers[239], newFakeAnswers[240], newFakeAnswers[241]).shuffled(),
            correctAnswer = "${newFakeAnswers[236].id},${newFakeAnswers[237].id},${newFakeAnswers[238].id}",
            typeQuestion = listOf(TypeQuestion.CLIMATE_CHANGE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1128",
            question = "Recursos renovables",
            answers = listOf(newFakeAnswers[242], newFakeAnswers[243], newFakeAnswers[244], newFakeAnswers[245], newFakeAnswers[246], newFakeAnswers[247]).shuffled(),
            correctAnswer = "${newFakeAnswers[242].id},${newFakeAnswers[243].id},${newFakeAnswers[244].id}",
            typeQuestion = listOf(TypeQuestion.ENERGY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1129",
            question = "Contaminación del aire",
            answers = listOf(newFakeAnswers[248], newFakeAnswers[249], newFakeAnswers[250], newFakeAnswers[251], newFakeAnswers[252], newFakeAnswers[253]).shuffled(),
            correctAnswer = "${newFakeAnswers[248].id},${newFakeAnswers[249].id},${newFakeAnswers[250].id}",
            typeQuestion = listOf(TypeQuestion.CONTAMINATION),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1130",
            question = "Energía no renovable",
            answers = listOf(newFakeAnswers[254], newFakeAnswers[255], newFakeAnswers[256], newFakeAnswers[257], newFakeAnswers[258], newFakeAnswers[259]).shuffled(),
            correctAnswer = "${newFakeAnswers[254].id},${newFakeAnswers[255].id},${newFakeAnswers[256].id}",
            typeQuestion = listOf(TypeQuestion.ENERGY),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1131",
            question = "Residuos reciclables",
            answers = listOf(newFakeAnswers[260], newFakeAnswers[261], newFakeAnswers[262], newFakeAnswers[263], newFakeAnswers[264], newFakeAnswers[265]).shuffled(),
            correctAnswer = "${newFakeAnswers[260].id},${newFakeAnswers[261].id},${newFakeAnswers[262].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1132",
            question = "Contaminación del agua",
            answers = listOf(newFakeAnswers[266], newFakeAnswers[267], newFakeAnswers[268], newFakeAnswers[269], newFakeAnswers[270], newFakeAnswers[271]).shuffled(),
            correctAnswer = "${newFakeAnswers[266].id},${newFakeAnswers[267].id},${newFakeAnswers[268].id}",
            typeQuestion = listOf(TypeQuestion.CONTAMINATION),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1133",
            question = "Gases de efecto invernadero",
            answers = listOf(newFakeAnswers[272], newFakeAnswers[273], newFakeAnswers[274], newFakeAnswers[275], newFakeAnswers[276], newFakeAnswers[277]).shuffled(),
            correctAnswer = "${newFakeAnswers[272].id},${newFakeAnswers[273].id},${newFakeAnswers[274].id}",
            typeQuestion = listOf(TypeQuestion.CLIMATE_CHANGE),
            typeGame = TypeGame.RELATIONS,
        ),
        Question(
            id = "1134",
            question = "Materiales biodegradables",
            answers = listOf(newFakeAnswers[278], newFakeAnswers[279], newFakeAnswers[280], newFakeAnswers[281], newFakeAnswers[282], newFakeAnswers[283]).shuffled(),
            correctAnswer = "${newFakeAnswers[278].id},${newFakeAnswers[279].id},${newFakeAnswers[280].id}",
            typeQuestion = listOf(TypeQuestion.RECYCLE),
            typeGame = TypeGame.RELATIONS,
        ),
    )

}
