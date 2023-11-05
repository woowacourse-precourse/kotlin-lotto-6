package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.FIFTH_RANK
import util.Constants.FIFTH_PRIZE_AMOUNT
import util.Constants.FIRST_RANK
import util.Constants.FIRST_PRIZE_AMOUNT
import util.Constants.FOURTH_RANK
import util.Constants.FOURTH_PRIZE_AMOUNT
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Constants.LOTTO_MAX_NUMBER
import util.Constants.LOTTO_MIN_NUMBER
import util.Constants.LOTTO_TOTAL_NUMBER
import util.Constants.NO_RANK
import util.Constants.NO_PRIZE_AMOUNT
import util.Constants.SECOND_RANK
import util.Constants.SECOND_PRIZE_AMOUNT
import util.Constants.THIRD_RANK
import util.Constants.THIRD_PRIZE_AMOUNT

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val numberOfPurchases = getNumberOfPurchase(purchaseAmount)
        val lottos = makeLottos(numberOfPurchases)
        purchaseLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        val winningRanks = getWinningRanks(lottos, winningNumbers, bonusNumber)
        getRateOfReturn(purchaseAmount, winningRanks)
    }

    fun getPurchaseAmount(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            inputView.inputPurchaseAmount()
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getPurchaseAmount()
        }
    }

    fun getNumberOfPurchase(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_AMOUNT_UNIT
    }

    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_TOTAL_NUMBER)
    }

    fun makeLottos(numberOfPurchase: Int): List<Lotto> {
        return List(numberOfPurchase) { Lotto(generateLottoNumbers()) }
    }

    fun purchaseLottos(lottos: List<Lotto>) {
        outputView.printNumberOfPurchases(lottos.size)
        for (lotto in lottos) {
            outputView.printLotto(lotto)
        }
    }

    fun getWinningNumbers(): List<Int> {
        outputView.printWinningNumbersInstruction()
        return try {
            inputView.inputWinningNumbers()
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        outputView.printBonusNumberInstruction()
        return try {
            inputView.inputBonusNumber(winningNumbers)
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getBonusNumber(winningNumbers)
        }
    }

    fun getWinningRanks(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Int> {
        outputView.printWinningStatisticsInstruction()
        val winningStatistics = mutableListOf<Pair<Int, Boolean>>()
        for (lotto in lottos) {
            val matchedNumbers = getMatchedNumbers(lotto, winningNumbers)
            val bonusMatched = getBonusMatched(lotto, bonusNumber)
            winningStatistics.add(Pair(matchedNumbers, bonusMatched))
        }
        val winningRanks = judgementWinningRanks(winningStatistics)
        outputView.printWinningStatistics(winningRanks)
        return winningRanks
    }

    fun getMatchedNumbers(lotto: Lotto, winningNumbers: List<Int>): Int {
        return lotto.getNumbers().intersect(winningNumbers).size
    }

    fun getBonusMatched(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }

    fun judgementWinningRanks(winningStatistics: List<Pair<Int, Boolean>>): List<Int> {
        val winningRanks = mutableListOf(0, 0, 0, 0, 0, 0)
        for (winningStatistic in winningStatistics) {
            val winningRank = when {
                winningStatistic.first == 6 -> FIRST_RANK
                winningStatistic.first == 5 && winningStatistic.second -> SECOND_RANK
                winningStatistic.first == 5 -> THIRD_RANK
                winningStatistic.first == 4 -> FOURTH_RANK
                winningStatistic.first == 3 -> FIFTH_RANK
                else -> NO_RANK
            }
            winningRanks[winningRank] += 1
        }
        return winningRanks
    }

    fun getRateOfReturn(purchaseAmount: Int, winningRanks: List<Int>) {
        var winningAmount = 0.0
        for (winningRank in FIRST_RANK..FIFTH_RANK) {
            winningAmount += calculateWinningAmount(winningRank, winningRanks[winningRank])
        }
        val rateOfReturn = (winningAmount / purchaseAmount) * 100
        outputView.printRateOfReturn(rateOfReturn)
    }

    fun calculateWinningAmount(winningRank: Int, numberOfWinningRank: Int): Int {
        return when (winningRank) {
            FIRST_RANK -> FIRST_PRIZE_AMOUNT * numberOfWinningRank
            SECOND_RANK -> SECOND_PRIZE_AMOUNT * numberOfWinningRank
            THIRD_RANK -> THIRD_PRIZE_AMOUNT * numberOfWinningRank
            FOURTH_RANK -> FOURTH_PRIZE_AMOUNT * numberOfWinningRank
            FIFTH_RANK -> FIFTH_PRIZE_AMOUNT * numberOfWinningRank
            else -> NO_PRIZE_AMOUNT
        }
    }
}