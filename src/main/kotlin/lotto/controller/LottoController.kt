package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Constants.LOTTO_NUMBER_END
import util.Constants.LOTTO_NUMBER_START
import util.Constants.LOTTO_TOTAL_NUMBER
import util.Validator.validateBonusNumber
import util.Validator.validatePurchaseAmount
import util.Validator.validateWinningNumbers

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val numberOfPurchases = getNumberOfPurchases()
        val lottos = makeLottos(numberOfPurchases)
        purchaseLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
    }

    fun getNumberOfPurchases(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            val purchaseAmount = inputView.inputPurchaseAmount()
            validatePurchaseAmount(purchaseAmount) / LOTTO_AMOUNT_UNIT
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
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

    fun getWinningNumbers(): List<Int> {
        outputView.printWinningNumbersInstruction()
        return try {
            val winnerNumbers = inputView.inputWinningNumbers()
            validateWinningNumbers(winnerNumbers)
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        outputView.printBonusNumberInstruction()
        return try {
            val bonusNumber = inputView.inputBonusNumber()
            validateBonusNumber(bonusNumber, winningNumbers)
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getBonusNumber(winningNumbers)
        }
    }
}