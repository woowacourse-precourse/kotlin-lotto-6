package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.models.Lotto
import lotto.models.WinningRank
import lotto.models.roundTo2DecimalPlaces
import kotlin.math.roundToInt

class LottoGame(private val user: User) {

    fun start() {
        showMessage(INPUT_AMOUNT_MESSAGE)
        val amount = inputAmountFromUser()

        val lottoCount = calculateLottoCount(amount)
        showMessage(PURCHASED_LOTTO_COUNT_MESSAGE.format(lottoCount))

        val lottos = publishLottos(lottoCount)
        lottos.forEach { showMessage(makeLottoNumbersMessage(it)) }

        showMessage(INPUT_WINNING_NUMBERS_MESSAGE)
        val winningNumbers = inputWinningNumbersFromUser()

        showMessage(INPUT_BONUS_NUMBER_MESSAGE)
        val bonusNumber = inputBonusNumberFromUser()

        val winningRecord = recordWinning(lottos, winningNumbers, bonusNumber)
        showMessage(WINNING_STATISTICS_LABEL)
        //showWinningRecordMessages(winningRecord)

        val roi = calculateROI(amount, winningRecord)
        showMessage(ROI_MESSAGE.format(roi.roundTo2DecimalPlaces()))
    }

    private fun inputAmountFromUser(): Int {
        while (user.amount == 0) {
            try {
                user.inputAmount()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.amount
    }

    private fun inputWinningNumbersFromUser(): List<Int> {
        while (user.winningNumbers.isEmpty()) {
            try {
                user.inputWinningNumbers()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.winningNumbers
    }

    private fun inputBonusNumberFromUser(): Int {
        while (user.bonusNumber == 0) {
            try {
                user.inputBonusNumber()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.bonusNumber
    }

    private fun calculateLottoCount(amount: Int): Int = amount / User.AMOUNT_UNIT

    private fun publishLottos(lottoCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(lottoCount) {
            val lotto = Lotto(generateLottoNumbers())
            lottos.add(lotto)
        }

        return lottos
    }

    private fun generateLottoNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)

    private fun makeLottoNumbersMessage(lotto: Lotto): String = LOTTO_NUMBERS_MESSAGE.format(formatLottoNumbers(lotto))

    private fun formatLottoNumbers(lotto: Lotto): String = lotto.getNumbers().joinToString(LOTTO_NUMBER_SEPARATOR)

    private fun recordWinning(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<WinningRank, Int> {
        val winningRecord = mutableMapOf<WinningRank, Int>()

        lottos.forEach { lotto ->
            val winning = calculateWinningResult(lotto, winningNumbers, bonusNumber)
            winning?.let {
                winningRecord[it] = (winningRecord[it] ?: 0) + 1
            }
        }

        return winningRecord
    }

    private fun calculateWinningResult(lotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): WinningRank? {
        val (matchCount, isMatchBonus) = matchLottoWithWinningNumbers(
            lotto.getNumbers(),
            winningNumbers,
            bonusNumber
        )

        return WinningRank.find(matchCount, isMatchBonus)
    }

    private fun matchLottoWithWinningNumbers(
        lottoNumbers: List<Int>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Pair<Int, Boolean> {
        val matchedCount = lottoNumbers.count { it in winningNumbers }
        val isMatchedBonus = bonusNumber !in winningNumbers && bonusNumber in lottoNumbers

        return Pair(matchedCount, isMatchedBonus)
    }

//    private fun showWinningRecordMessages(winningRecord: Map<WinningRank, Int>) {
//        val winnings = WinningRank.getSortedWinnings()
//
//        winnings.forEach {
//            val matchCount = winningRecord[it] ?: 0
//            if (it.hasBonus) {
//                showMessage(WINNING_WITH_BONUS_MESSAGE.format(it.count, it.amount.withCommas(), matchCount))
//            } else {
//                showMessage(WINNING_WITHOUT_BONUS_MESSAGE.format(it.count, it.amount.withCommas(), matchCount))
//            }
//        }
//    }

    private fun calculateROI(purchasedAmount: Int, winningRecord: Map<WinningRank, Int>): Double {
        val totalWinningAmount = winningRecord.entries.sumOf { (winning, count) -> winning.amount * count }
        val roi = ((totalWinningAmount.toDouble() - purchasedAmount) / purchasedAmount) * 100

        return 100 + roi.roundTo2DecimalPlaces()
    }

    private fun showMessage(message: String) = println(message)

    private fun showErrorMessage(errorMessage: String) = println("$PREFIX_ERROR_MESSAGE $errorMessage")

    companion object {
        const val PREFIX_ERROR_MESSAGE = "[ERROR]"
        const val UNKNOWN_ERROR_MESSAGE = "알 수 없는 에러가 발생했습니다."

        const val INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val PURCHASED_LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다."

        const val LOTTO_NUMBERS_MESSAGE = "[%s]"
        const val LOTTO_NUMBER_SEPARATOR = ", "

        const val WINNING_STATISTICS_LABEL = "당첨 통계\n---"
        const val WINNING_WITHOUT_BONUS_MESSAGE = "%d개 일치 (%s원) - %d개"
        const val WINNING_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"

        const val ROI_MESSAGE = "총 수익률은 %.1f%%입니다."
    }
}

fun Int.withCommas(): String {
    return "%,d".format(this)
}