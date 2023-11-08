package lotto

fun Long.toDecimalFormat(): String {
    return String.format("%,d", this)
}