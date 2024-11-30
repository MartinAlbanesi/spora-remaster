package com.gg.spora.core.utils.functions

fun calculateProgress(valor: Int, minOriginal: Int = 0, maxOriginal: Int): Float {
    return (valor - minOriginal).toFloat() / (maxOriginal - minOriginal).toFloat()
}