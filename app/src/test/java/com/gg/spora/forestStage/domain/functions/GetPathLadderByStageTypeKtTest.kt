package com.gg.spora.forestStage.domain.functions

import com.gg.spora.core.utils.SporaConstant
import com.gg.spora.core.utils.enums.StageType
import org.junit.Assert.assertEquals
import org.junit.Test

class GetPathLadderByStageTypeKtTest {

    @Test
    fun getPathLadderByStageTypeTest() {

        val path = getPathLadderByStageType(StageType.FOREST)

        assert(path.isNotEmpty())
        assertEquals(4, path.size)
        assertEquals(SporaConstant.PATH_LADDER, path)

    }
}