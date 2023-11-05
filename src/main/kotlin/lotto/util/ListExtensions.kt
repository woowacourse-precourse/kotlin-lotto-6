package lotto.util

val lottoNumberRange = 1..45

fun <T> List<T>.isUnique(): Boolean {
    val uniqueItems = this.toSet()
    return this.size == uniqueItems.size
}

fun Int.isInLottoNumberRange(): Boolean {
    return this in lottoNumberRange
}

fun List<Int>.isInLottoNumberRange(): Boolean {
    this.forEach { number ->
        if (!number.isInLottoNumberRange()) {
            return false
        }
    }
    return true
}
