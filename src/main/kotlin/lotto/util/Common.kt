package lotto.util

import java.text.DecimalFormat

const val LOTTO_PRICE = 1000

fun applyPriceFormat(price: Int): String {
    val decimalFormat = DecimalFormat("#,###")
    return "${decimalFormat.format(price)}원"
}