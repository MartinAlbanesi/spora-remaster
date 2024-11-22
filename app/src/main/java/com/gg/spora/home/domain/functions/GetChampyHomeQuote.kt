package com.gg.spora.home.domain.functions

fun getChampyHomeQuote(userName: String): String {

    val champyHomeQuotes = listOf(
        "Bienvenido de nuevo $userName, ¿Que hacemos hoy?",
        "¡Hola $userName, veamos qué aprender hoy!",
        "Hola de nuevo $userName ¡La aventura espera!",
        "¡Qué bueno verte, $userName! ¿Empezamos por una aventura?",
        "¡Te extrañé, $userName! Estoy impaciente por aprender más hoy.",
    )

    return champyHomeQuotes.random()
}