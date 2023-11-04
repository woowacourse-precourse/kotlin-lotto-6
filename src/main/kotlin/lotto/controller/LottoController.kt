package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Constants.LOTTO_NUMBER_END
import util.Constants.LOTTO_NUMBER_START
import util.Constants.LOTTO_TOTAL_NUMBER
import util.Validator.validatePurchaseAmount

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val numberOfPurchases = getNumberOfPurchases()
        val lottos = makeLottos(numberOfPurchases)
        purchaseLottos(lottos)
    }

    fun getNumberOfPurchases(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            val purchaseAmount = inputView.inputPurchaseAmount()
            validatePurchaseAmount(purchaseAmount) / LOTTO_AMOUNT_UNIT
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printPurchaseAmountErrorMessage(illegalArgumentException.message.toString())
            getNumberOfPurchases()
        }
    }

    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_TOTAL_NUMBER)
    }

    fun makeLottos(numberOfPurchase: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (number in 0 until numberOfPurchase) {
            lottos.add(Lotto(generateLottoNumbers()))
        }
        return lottos
    }

    fun purchaseLottos(lottos: List<Lotto>) {
        outputView.printNumberOfPurchases(lottos.size)
        for (lotto in lottos) {
            outputView.printLottoNumbers(lotto)
        }
    }
}