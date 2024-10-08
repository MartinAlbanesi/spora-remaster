package com.gg.spora.minigameRelations.domain

//data class Answer(val text: String, val isCorrect: Boolean)

class GameLogic {
    private val correctAnswers = listOf("Reciclable", "Biodegradable", "Plástico")

    fun getAnswers(): List<Answer> {
        return listOf(
            Answer("No reciclable", isCorrect = false),
            Answer("Reciclable", isCorrect = true),
            Answer("Contaminante", isCorrect = true),
            Answer("Biodegradable", isCorrect = false),
            Answer("Orgánico", isCorrect = false),
            Answer("Plástico", isCorrect = true)
        )
    }

   /* fun validateAnswer(answer: String): Boolean {
        return correctAnswers.contains(answer)
    }*/
}
