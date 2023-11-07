package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoCompare
import lotto.util.BONUS_NUMBER_TEXT
import lotto.util.WINNING_NUMBER_TEXT

object LottoDecisionView {
    fun printWinningNumber() {
        println(WINNING_NUMBER_TEXT)
    }

    fun inputWinningNumber() {
        // 당첨 번호 입력 구현
        val winningNumbers = Console.readLine().trim()
        println()
        printBonusNumber()
        LottoCompare().winning(winningNumbers)
    }

    private fun printBonusNumber() {
        println(BONUS_NUMBER_TEXT)
        inputBonusNumber()
    }

    private fun inputBonusNumber() {
        // 보너스 번호 입력 구현
        val bonusNumbers = Console.readLine().trim()
        println()
        LottoCompare().bonus(bonusNumbers)
    }
}