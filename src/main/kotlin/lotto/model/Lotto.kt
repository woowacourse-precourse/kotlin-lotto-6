package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            NUM_AMOUNT_ERROR_MESSAGE
        }

        require(numbers.toSet().size == numbers.size) {
            UNIQUE_NUM_ERROR_MESSAGE
        }
    }

    fun matchAnswer(answerNum: List<Int>, bonusNum: Int): WinningType {
        val hitNum = answerNum.intersect(numbers)
        return when (hitNum.size) {
            6 -> WinningType.FIRST
            5 -> isContainBonus(bonusNum)
            4 -> WinningType.FOURTH
            3 -> WinningType.FIFTH
            else -> WinningType.NOTHING
        }
    }

    private fun isContainBonus(bonusNum: Int): WinningType {
        return when (numbers.contains(bonusNum)) {
            true -> WinningType.SECOND
            false -> WinningType.THIRD
        }
    }

    fun printLottoNumbers() {
        println(numbers)
    }

    companion object {
        private const val NUM_AMOUNT_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요"
        private const val UNIQUE_NUM_ERROR_MESSAGE = "[ERROR] 서로 다른 숫자를 입력해주세요."
    }
}
