package lotto

class Bonus(private val number: Int) {

    init {
        require(isValidNumberRange(number)) { INVALID_NUMBER_RANGE_ERROR_MESSAGE }
    }

    fun getNumber() = number

    private fun isValidNumberRange(number: Int) = number in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER

    companion object {
        const val INVALID_NUMBER_RANGE_ERROR_MESSAGE =
            "보너스 번호는 ${Lotto.MIN_NUMBER}에서 ${Lotto.MAX_NUMBER}사이여야 합니다."
    }
}