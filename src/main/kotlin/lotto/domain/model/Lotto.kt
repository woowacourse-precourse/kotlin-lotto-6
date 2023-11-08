package lotto.domain.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { MISMATCH_NUMBER_OF_LOTTO_NUMBERS_MESSAGE }
        require(!numbers.containsDuplicatedNumber()) { DUPLICATED_NUMBER_EXIST_MESSAGE }
        require(numbers.inValidRange()) { NUMBERS_NOT_IN_VALID_RANGE }
        require(numbers.inAscendingOrder()) { NUMBERS_NOT_IN_ASCENDING_ORDER }
    }

    private fun List<Int>.containsDuplicatedNumber(): Boolean = this.toSet().size != this.size

    private fun List<Int>.inValidRange(): Boolean {
        this.forEach { if (it !in validRange) return false }
        return true
    }

    private fun List<Int>.inAscendingOrder(): Boolean = this == this.sortedBy { it }

    override fun toString(): String = numbers.toString()

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        val validRange = (MIN_NUMBER..MAX_NUMBER)
        const val NUMBER_OF_LOTTO_NUMBERS = 6
        const val MISMATCH_NUMBER_OF_LOTTO_NUMBERS_MESSAGE = "${NUMBER_OF_LOTTO_NUMBERS}의 숫자가 필요합니다."
        const val DUPLICATED_NUMBER_EXIST_MESSAGE = "중복된 숫자가 존재합니다."
        const val NUMBERS_NOT_IN_VALID_RANGE = "모든 숫자는 반드시 $MIN_NUMBER~$MAX_NUMBER 사이에 존재해야 합니다."
        const val NUMBERS_NOT_IN_ASCENDING_ORDER = "로또 번호가 오름차순이 되도록 해주세요."
    }
}
