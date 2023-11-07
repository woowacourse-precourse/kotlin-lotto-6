package lotto.util


fun String.parseInt(): Int {
    return this.toIntOrNull() ?: throw IllegalArgumentException(ErrorConstants.NOT_NUMBER)
}

fun Int.validatePositive(): Int {
    require(this > 0) { ErrorConstants.NOT_POSITIVE }
    return this
}

fun Int.validateMultipleOf(divisor: Int): Int {
    require(this % divisor == 0) { " ${ErrorConstants.NOT_MULTIPLIER} $divisor" }
    return this
}

fun String.parseIntList(): List<Int> {
    return this.split(',').map { it.toIntOrNull() ?: throw IllegalArgumentException(ErrorConstants.NOT_NUMBER_LIST) }
}

fun List<Int>.validateCount(count: Int): List<Int> {
    require(this.size == count) { "${ErrorConstants.NOT_FIT_COUNT} $count" }
    return this
}

fun List<Int>.validateUnique(count: Int): List<Int> {
    require(this.toSet().size == count) { ErrorConstants.NOT_UNIQUE }
    return this
}

fun List<Int>.validateRange(start: Int, end: Int): List<Int> {
    require(this.all { it in start..end }) { "${ErrorConstants.NOT_FIT_RANGE} $start ~ $end" }
    return this
}
