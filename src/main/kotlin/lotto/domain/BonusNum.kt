package lotto.domain

import lotto.Lotto

class BonusNum(private val bonusNum: String) {
    init {
        require(isNum()) { println(IS_NOT_NUM) }
        require(checkNotIn1to45()) { println(NOT_IN_ONE_TO_FOURTY_FIVE) }
    }

    private fun isNum(): Boolean = bonusNum.all { number -> number.isDigit() }
    private fun checkNotIn1to45(): Boolean = bonusNum.toInt() in 1..45



    companion object {
        private const val IS_NOT_NUM = "[ERROR] 숫자로 입력해야 합니다."
        private const val NOT_IN_ONE_TO_FOURTY_FIVE = "[EROOR] 1부터 45 사이의 숫자여야 합니다."
    }
}

