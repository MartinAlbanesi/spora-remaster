package com.gg.spora.core.utils

sealed interface ResponseUiState {
    data object Loading : ResponseUiState
    data class Success<T>(val data: T) : ResponseUiState
    data class Error(val message: String) : ResponseUiState
}