package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    fun playLotto() {
        val purchaseMoney = getPurchaseMoney()
        val issuedLotto = LottoMaker().issueLotto(purchaseMoney)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()
        LottoInspector().showLottoResult(issuedLotto,winningNumbers,bonusNumber)
    }

    private fun getPurchaseMoney(): Int {
        purchaseInputMessage()
        val purchaseMoney = Console.readLine()
        Validation().purchaseMoneyValidation(purchaseMoney)
        return purchaseMoney.toInt()
    }

    private fun getWinningNumbers(): List<Int> {
        winningNumbersInputMessage()
        val winningNumbersInput = Console.readLine()
        return makeWinningNumbers(winningNumbersInput)
    }

    private fun getBonusNumber(): Int {
        bonusNumberInputMessage()
        val bonusNumber = Console.readLine()
        Validation().lottoNumberValidation(bonusNumber)
        return bonusNumber.toInt()
    }

    private fun makeWinningNumbers(winningNumbersInput: String): List<Int> {
        val winningNumberList = winningNumbersInput.split(",")
        for (number in winningNumberList) {
            Validation().lottoNumberValidation(number)
        }
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