package lotto.controller

import lotto.model.Lottoes
import lotto.model.Money
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController() {
    fun start() {
        val money = inputPurchasedMoney()
        val lottoes = purchaseLottoes(money.countOfPurchasedLotto)
        val winningNumbers = inputWinningNumbers()
        winningNumbers.setBonusNumber(inputBonusNumber())
        val winningStatistic = lottoes.confirmWinningNumbers(winningNumbers)
        val earningsRate = money.calculateEarningsRate(winningStatistic)
        OutputView.printWinningStatistics(winningStatistic, earningsRate)
    }

    private fun inputWinningNumbers(): WinningNumbers {
        while (true) {
            try {
                val winningNumbers = InputView.inputWinningNumbers()
                return WinningNumbers(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(): Int {
        while (true) {
            try {
                return InputView.inputBonusNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun purchaseLottoes(countOfPurchasedLotto: Int): Lottoes {
        val lottoes = Lottoes(countOfPurchasedLotto)
        OutputView.printCountOfPurchasedLotto(countOfPurchasedLotto)
        OutputView.printLottoes(lottoes.lottoes)
        return lottoes
    }

    private fun inputPurchasedMoney(): Money {
        while (true) {
            try {
                return Money(InputView.inputPurchasedMoney())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}