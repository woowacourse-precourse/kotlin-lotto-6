package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants
import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class GameController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val purchaseAmount = inputPurchaseAmount(inputView)
        val lottoNumbers = createLottos(purchaseAmount.Count)
        outputView.printPurchaseResults(lottoNumbers)


    }

    private fun inputPurchaseAmount(inputView: InputView): PurchaseAmount {
        val userInputData = inputView.purchaseAmountPrompt()
        return PurchaseAmount(userInputData)
    }

    private fun createLottos(count: Int): Lottos {
        return Lottos(
            List(count) {
                Lotto(createSortedUniqueNumbers())
            }
        )
    }

    private fun createSortedUniqueNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            LOTTO_RANGE_MIN_VALUE, LOTTO_RANGE_MAX_VALUE,
            Constants.LOTTO_NUMBER_SIZE
        ).sorted()
    }

    companion object {
        const val LOTTO_RANGE_MIN_VALUE = 1
        const val LOTTO_RANGE_MAX_VALUE = 45
    }
}