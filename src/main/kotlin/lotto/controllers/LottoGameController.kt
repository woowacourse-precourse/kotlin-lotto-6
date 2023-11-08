package lotto.controllers

import lotto.models.*
import lotto.views.InputView
import lotto.views.OutputView
import java.lang.Exception

class LottoGameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val winningRecord: WinningRecord = WinningRecord()

    fun start() {
        try {
            val purchase = inputPurchaseAmount()
            val purchasedLottos = purchaseLottos(purchase)
            val winningLotto = inputWinningLottoNumbers()
            val bonus = inputBonusNumber(winningLotto)

            recordWinning(purchasedLottos, winningLotto, bonus)
            calculateProfitRate(purchase)
        } catch (e: Exception) {
            outputView.printErrorMessage()
        } finally {
            inputView.closeInput()
        }
    }

    private fun purchaseLottos(purchase: Purchase): List<Lotto> {
        val publisher = Publisher()
        val purchasedLottos = publisher.publishLottos(purchase)

        outputView.printPurchasedLottos(purchasedLottos)

        return purchasedLottos
    }

    private fun recordWinning(purchasedLottos: List<Lotto>, winningLotto: Lotto, bonus: Bonus) {
        winningRecord.updateWinningResults(purchasedLottos, winningLotto, bonus)
        outputView.printWinningStatics(winningRecord)
    }

    private fun calculateProfitRate(purchase: Purchase) {
        val profitRate = ProfitRate()

        profitRate.calculate(purchase, winningRecord)
        outputView.printProfitRate(profitRate)
    }

    private fun inputPurchaseAmount(): Purchase {
        while (true) {
            try {
                val amount = inputView.inputPurchaseAmount()
                val purchase = Purchase(amount)

                inputView.endInput()

                return purchase
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
    }

    private fun inputWinningLottoNumbers(): Lotto {
        while (true) {
            try {
                val numbers = inputView.inputWinningNumbers()
                val lotto = Lotto(numbers)

                inputView.endInput()

                return lotto
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
    }

    private fun inputBonusNumber(winningLotto: Lotto): Bonus {
        while (true) {
            try {
                val number = inputView.inputBonusNumber()
                val bonus = Bonus(number)

                bonus.checkDistinctWithWinningLotto(winningLotto.getNumbers())
                inputView.endInput()

                return bonus
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
    }
}