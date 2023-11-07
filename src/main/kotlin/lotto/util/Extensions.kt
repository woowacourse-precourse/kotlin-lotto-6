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