package com.gg.spora.core.utils.functions

import com.gg.spora.core.utils.enums.TypeQuestion
import org.junit.Assert.*

import org.junit.Test

class GetTypeQuestionEnumKtTest {

    @Test
    fun getTypeQuestionEnumTest() {

        val expect = listOf("RECYCLE", "MARTIN", "RELATIONS_QUESTION")
        val actual = getTypeQuestionEnum(expect)
        assertEquals(3, actual.size)
        assertEquals(TypeQuestion.RECYCLE, actual[0])
    }
}