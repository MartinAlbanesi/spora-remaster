package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.TypeGame
import org.junit.Assert.assertEquals
import org.junit.Test

class GetTypeGameEnumKtTest {

    @Test
    fun getTypeGameEnumTest() {
        val typeGame = "QUIZ"
        val result = getTypeGameEnum(typeGame)
        assertEquals(TypeGame.QUIZ, result)
    }
}