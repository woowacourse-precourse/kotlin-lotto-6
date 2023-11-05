package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    fun purchaseInput() {
        purchaseInputMessage()
        val purchaseMoney = Console.readLine()
    }

    fun winningNumbersInput() {
        winningNumbersInputMessage()
        val winningNumbers = Console.readLine()
    }

    fun bonusNumberInput() {
        bonusNumberInputMessage()
        val bonusNumber = Console.readLine()
    }

    private fun purchaseInputMessage() {
        println("구입 금액을 입력해 주세요.")
    }

    private fun winningNumbersInputMessage() {
        println("당첨 번호를 입력해 주세요.")
    }

    private fun bonusNumberInputMessage() {
        println("보너스 번호를 입력해 주세요.")
    }
}