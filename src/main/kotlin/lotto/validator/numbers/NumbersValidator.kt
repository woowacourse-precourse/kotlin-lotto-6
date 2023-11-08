package lotto.validator.numbers

fun interface NumbersValidator {
    fun validate(value: List<Int>)
}