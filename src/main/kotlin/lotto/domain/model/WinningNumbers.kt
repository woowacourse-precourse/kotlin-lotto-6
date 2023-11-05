package lotto.domain.model

@JvmInline
value class WinningNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_OF_WINNING_NUMBERS) { MISMATCH_NUMBER_OF_WINNING_NUMBERS }
        require(!numbers.containsDuplicatedNumber()) { DUPLICATED_NUMBER_EXIST_EXCEPTION_MESSAGE }
        require(numbers.inValidRange()) { Lotto.NUMBERS_NOT_IN_VALID_RANGE }
    }

    private fun List<Int>.containsDuplicatedNumber(): Boolean = this.toSet().size != this.size

    private fun List<Int>.inValidRange(): Boolean {
        this.forEach { if (it !in Lotto.validRange) return false }
        return true
    }

    companion object {
        const val NUMBER_OF_WINNING_NUMBERS = Lotto.NUMBER_OF_LOTTO_NUMBERS
        const val MISMATCH_NUMBER_OF_WINNING_NUMBERS = "${NUMBER_OF_WINNING_NUMBERS}개의 숫자가 필요합니다."
        const val DUPLICATED_NUMBER_EXIST_EXCEPTION_MESSAGE = "중복된 숫자가 존재합니다."
    }
}