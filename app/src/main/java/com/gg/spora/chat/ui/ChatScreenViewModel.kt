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
    val response: ChampyResponseChat,
    val showNextIcon: Boolean,
//    val textSpeed
) {
    class Error(response: ChampyResponseChat) : ChatUiState(response, showNextIcon = false)
    class Loading(response: ChampyResponseChat) : ChatUiState(response, showNextIcon = false)
    class Standby(response: ChampyResponseChat) : ChatUiState(response, showNextIcon = false)
    class Success(response: ChampyResponseChat) : ChatUiState(response, showNextIcon = true)
}

data class ChampyResponseChat(
    val state: ChampyStates,
    val message: String
)


@HiltViewModel
class ChatScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _chatUiState = MutableStateFlow<ChatUiState>(
        ChatUiState.Standby(
            ChampyResponseChat(
                ChampyStates.SMILING,
                "Puedes preguntarme lo que quieras sobre el cuidado del medio ambiente!"
            )
        )
    )

    val chatUiState = _chatUiState.asStateFlow()

    private val _responseIA = MutableStateFlow<List<ChampyResponseChat>>(emptyList())

    private var _currentResponseIndex = 0

    private val _showTextField = MutableStateFlow(true)
    val showTextField = _showTextField.asStateFlow()

    init {
//        viewModelScope.launch(Dispatchers.IO) {
//
//            _showTextField.value = false
//
//            val wea = mapOf(
//                ChampyStates.NORMAL to "Soy Pestalotiopsis microspora, un hongo que vive en bosques tropicales.",
//                ChampyStates.SMILING to "Habito en hojas y ramas caídas, donde descompongo materia orgánica.",
//                ChampyStates.BLINK to "Tengo una habilidad especial: puedo degradar plásticos como el poliuretano.",
//                ChampyStates.GREETING to "Incluso puedo hacerlo sin oxígeno, algo poco común entre los hongos.",
//                ChampyStates.CURIOUS to "Por eso los científicos me estudian como posible ayuda contra la contaminación.",
//            )
//
//            _chatUiState.value = ChatUiState.Loading(
//                Pair(
//                    ChampyStates.CURIOUS,
//                    "Estoy pensando en una respuesta para ti..."
//                )
//            )
//            delay(2000)
//
//            _responseIA.value = wea
//
//            _chatUiState.value = ChatUiState.Success(
//                Pair(
//                    wea.keys.first(),
//                    wea.values.first()
//                )
//            )
//        }
    }


    fun nextResponse() {
        if (_currentResponseIndex >= _responseIA.value.size ) {
            _currentResponseIndex = 0
            _chatUiState.value = ChatUiState.Standby(
                ChampyResponseChat(
                    ChampyStates.SMILING,
                    "¿Quieres preguntarme algo más?"
                )
            )
            _showTextField.value = true
            return
        }


        val state = _responseIA.value[_currentResponseIndex].state
        val message = _responseIA.value[_currentResponseIndex].message

        _chatUiState.value = ChatUiState.Success(
            ChampyResponseChat(state, message)
        )
        _currentResponseIndex++
    }

    fun getResponseFromIA(message: String){
        viewModelScope.launch(Dispatchers.IO) {

            _showTextField.value = false

            val wea = listOf(
                ChampyResponseChat(ChampyStates.NORMAL, "¡Yo soy Champy!"),
                ChampyResponseChat(ChampyStates.NORMAL, "Soy de la familia Pestalotiopsis microspora, un hongo que vive en bosques tropicales."),
                ChampyResponseChat(ChampyStates.SMILING, "Habito en hojas y ramas caídas, donde descompongo materia orgánica."),
                ChampyResponseChat(ChampyStates.BLINK, "Tengo una habilidad especial: puedo degradar plásticos como el poliuretano."),
                ChampyResponseChat(ChampyStates.GREETING, "Incluso puedo hacerlo sin oxígeno, algo poco común entre los hongos."),
                ChampyResponseChat(ChampyStates.CURIOUS, "Por eso los científicos me estudian como posible ayuda contra la contaminación."),
            )


            _chatUiState.value = ChatUiState.Loading(
                ChampyResponseChat(
                    ChampyStates.CURIOUS,
                    "Estoy pensando en una respuesta para vos..."
                )
            )
            delay(2000)

            _responseIA.value = wea

            _chatUiState.value = ChatUiState.Success(
                ChampyResponseChat(
                    wea.first().state,
                    wea.first().message
                )
            )

            _currentResponseIndex++
        }
    }

}