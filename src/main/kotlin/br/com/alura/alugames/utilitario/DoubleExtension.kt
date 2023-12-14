package br.com.alura.alugames.utilitario

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.formatoComDuasCasasDecimais(): Double {
    val decimalFormat = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US))
    return decimalFormat.format(this).toDouble()
}