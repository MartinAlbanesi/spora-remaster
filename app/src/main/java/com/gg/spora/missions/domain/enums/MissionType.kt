package com.gg.spora.missions.domain.enums

enum class MissionType(
    val missionId: Byte,
    val text: String,
) {
    AD_MISSION(0, "Mira un anuncio"),
    LIBRARY_MISSION(1, "Visita a Mushy"),
    MINI_GAME_MISSION(2,  "Juega un mini juego"),
    GROVE_MISSION(3, "Planta un árbol"),
    SCAN_MISSION(4, "Escanea un objeto y reciclalo"),
}