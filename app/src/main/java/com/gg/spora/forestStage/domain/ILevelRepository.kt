package com.gg.spora.forestStage.domain

import com.gg.spora.forestStage.domain.model.Level

interface ILevelRepository {

    fun getLevels(count : Int, typeLevel: Level): List<Level>
}