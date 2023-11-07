package lotto.presentation

import camp.nextstep.edu.missionutils.Console

class LottoPresentation {
    fun getLottoPurchaseAmountInput(): String {
        println("구입금액을 입력해 주세요.")
        val purchaseLottoInput = Console.readLine()
        return purchaseLottoInput
    }

    fun getWinningNumbersInput(): String {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbersInput = Console.readLine()
        return winningNumbersInput
    }

    fun getBonusNumbersInput(): String {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumbersInput = Console.readLine()
        return bonusNumbersInput
    }
}