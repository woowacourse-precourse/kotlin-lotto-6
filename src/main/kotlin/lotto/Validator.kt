package lotto

enum class ValidatorError(val message: String) {
    NotNumber("문자는 입력할 수 없습니다."),
    NotPositiveNumber("음수나 0 값은 입력할 수 없습니다.")
}

fun <T> T.requireAndReturn(value: Boolean, message: String): T {
    require(value) { message }
    return this
}

fun String.toValidInt(): Int = requireAndReturn(this.isInt(), ValidatorError.NotNumber.message).toInt()

fun Int.validPositiveNumber(): Int = requireAndReturn(this.isPositiveNumber(), ValidatorError.NotPositiveNumber.message)

fun String.isInt(containsSign: Boolean = false): Boolean {
    if (isBlank()) return false
    if (!containsSign && this[0] in listOf('-', '+')) return false
    return toIntOrNull() != null
}

fun Int.isPositiveNumber(): Boolean = this > 0

fun Int.isInRange(start: Int, end: Int): Boolean = this in start..end