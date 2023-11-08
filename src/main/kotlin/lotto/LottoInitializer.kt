package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    fun playLotto() {
        val purchaseMoney = getPurchaseMoney()
        val issuedLotto = LottoMaker().issueLotto(purchaseMoney)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        LottoInspector().showLottoResult(issuedLotto,winningNumbers,bonusNumber)
    }

    private fun getPurchaseMoney(): Int {
        purchaseInputMessage()
        val purchaseMoney = Console.readLine()
        try {
            Validation().purchaseMoneyValidation(purchaseMoney)
        } catch (_: IllegalArgumentException) {
            Validation().purchaseMoneyErrorMessage()
            return getPurchaseMoney()
        }
        println()
        return purchaseMoney.toInt()
    }

    private fun getWinningNumbers(): List<Int> {
        winningNumbersInputMessage()
        val winningNumbersInput = Console.readLine()
        try {
            Validation().winningNumbersValidation(winningNumbersInput)
        } catch (_: IllegalArgumentException) {
            Validation().winningNumbersErrorMessage()
            return getWinningNumbers()
        }
        println()
        return makeWinningNumbers(winningNumbersInput)
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        bonusNumberInputMessage()
        val bonusNumber = Console.readLine()
        try {
            Validation().bonusNumberValidation(winningNumbers,bonusNumber)
        } catch (_: IllegalArgumentException) {
            Validation().bonusNumberErrorMessage()
            return getBonusNumber(winningNumbers)
        }
        println()
        return bonusNumber.toInt()
    }

    private fun makeWinningNumbers(winningNumbersInput: String): List<Int> {
        val winningNumberList = winningNumbersInput.split(",")
        return winningNumberList.map { it.toInt() }
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