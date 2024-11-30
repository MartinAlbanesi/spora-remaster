package com.gg.spora.missions.domain.enums

enum class MissionType(
    val missionId: Byte,
    val text: String,
) {
    LIBRARY_MISSION(0, "Visita a Mushy"),
    MINI_GAME_MISSION(1,  "Juega un mini juego"),
    GROVE_MISSION(2, "Planta un árbol"),
    SCAN_MISSION(3, "Escanea un objeto y reciclalo"),
}