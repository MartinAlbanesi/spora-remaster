package com.gg.spora.chat.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gg.spora.core.utils.enums.ChampyStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class ChatUiState(
    val response: Pair<ChampyStates, String>,
    val showNextIcon: Boolean
) {
    class Error(response: Pair<ChampyStates, String>) : ChatUiState(response, showNextIcon = false)
    class Loading(response: Pair<ChampyStates, String>) : ChatUiState(response, showNextIcon = false)
    class Standby(response: Pair<ChampyStates, String>) : ChatUiState(response, showNextIcon = false)
    class Success(response: Pair<ChampyStates, String>) : ChatUiState(response, showNextIcon = true)
}


@HiltViewModel
class ChatScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _chatUiState = MutableStateFlow<ChatUiState>(
        ChatUiState.Standby(
            Pair(
                ChampyStates.SMILING,
                "Puedes preguntarme lo que quieras el cuidado del medio ambiente!"
            )
        )
    )

    val chatUiState = _chatUiState.asStateFlow()

    private val _responseIA = MutableStateFlow<Map<ChampyStates, String>>(emptyMap())

    private var _currentResponseIndex = 1

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val wea = mapOf(
                ChampyStates.NORMAL to "Soy Pestalotiopsis microspora, un hongo que vive en bosques tropicales.",
                ChampyStates.SMILING to "Habito en hojas y ramas caídas, donde descompongo materia orgánica.",
                ChampyStates.BLINK to "Tengo una habilidad especial: puedo degradar plásticos como el poliuretano.",
                ChampyStates.GREETING to "Incluso puedo hacerlo sin oxígeno, algo poco común entre los hongos.",
                ChampyStates.CURIOUS to "Por eso los científicos me estudian como posible ayuda contra la contaminación.",
            )

            _chatUiState.value = ChatUiState.Loading(
                Pair(
                    ChampyStates.CURIOUS,
                    "Estoy pensando en una respuesta para ti..."
                )
            )
            delay(2000)

            _responseIA.value = wea

            _chatUiState.value = ChatUiState.Success(
                Pair(
                    wea.keys.first(),
                    wea.values.first()
                )
            )
        }
    }


    fun nextResponse() {
        if (_currentResponseIndex >= _responseIA.value.size ) {
            _currentResponseIndex = 0
            _chatUiState.value = ChatUiState.Standby(
                Pair(
                    ChampyStates.SMILING,
                    "¿Quieres preguntarme algo más sobre el cuidado del medio ambiente?"
                )
            )
            return
        }


        val state = _responseIA.value.keys.toList()[_currentResponseIndex]
        val message = _responseIA.value.values.toList()[_currentResponseIndex]

        _chatUiState.value = ChatUiState.Success(
            Pair(state, message)
        )
        _currentResponseIndex++

    }

}