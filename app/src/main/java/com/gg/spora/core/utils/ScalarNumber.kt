package com.gg.spora.core.utils

fun scalarNumber(valor: Int, minOriginal: Int = 0, maxOriginal: Int): Float {
    return (valor - minOriginal).toFloat() / (maxOriginal - minOriginal).toFloat()
}