package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants.LOTTO_PRICE
import lotto.Constants.MAX_LOTTO_NUMBER
import lotto.Constants.MIN_LOTTO_NUMBER
import lotto.Constants.THREE_MATCH_WINNING_AMOUNT
import lotto.Constants.FORE_MATCH_WINNING_AMOUNT
import lotto.Constants.FIVE_MATCH_WINNING_AMOUNT
import lotto.Constants.FIVE_WITH_BONUS_MATCH_WINNING_AMOUNT
import lotto.Constants.SIX_MATCH_WINNING_AMOUNT
import lotto.model.LottoRank

class LottoGameService {
    fun calculateLottoPurchaseQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun lottoNumberGenerator(ticket: Int): MutableMap<Int, List<Int>> {
        val purchaseLottoLists = mutableMapOf<Int, List<Int>>()
        for (ticketCheck in 0 until ticket) {
            purchaseLottoLists[ticketCheck] = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, 6
            ).sorted()
        }
        return purchaseLottoLists
    }

    fun calculateWinningStatistics(
        lotto: List<Int>,
        bonus: String,
        randomLottoLists: MutableMap<Int, List<Int>>,
        ticket: Int
    ) {
        for (ticketCheck in 0 until ticket) {
            val winningLottoCheck = checkWinningLottoNumber(lotto, randomLottoLists, ticketCheck)
            val bonusNumberCheck = checkWinningBonusNumber(bonus, randomLottoLists, ticketCheck)
            saveWinningStatsToRank(winningLottoCheck, bonusNumberCheck, ticketCheck)
        }
    }

    private fun checkWinningLottoNumber(
        lotto: List<Int>,
        randomLottoLists: MutableMap<Int, List<Int>>,
        ticketCheck: Int
    ): Int {
        return randomLottoLists[ticketCheck]!!.intersect(lotto.toSet()).count()
    }

    private fun checkWinningBonusNumber(
        bonus: String,
        randomLottoLists: MutableMap<Int, List<Int>>,
        ticketCheck: Int
    ): Boolean {
        return randomLottoLists[ticketCheck]!!.contains(bonus.toInt())
    }

    private fun saveWinningStatsToRank(winningLottoCheck: Int, bonusNumberCheck: Boolean, ticketCheck: Int) {
        if (winningLottoCheck == 3 || winningLottoCheck == 2 && bonusNumberCheck) {
            LottoRank.THREE_MATCH.increment()
        }
        if (winningLottoCheck == 4 || winningLottoCheck == 3 && bonusNumberCheck) {
            LottoRank.FOUR_MATCH.increment()
        }
        if (winningLottoCheck == 5) {
            LottoRank.FIVE_MATCH.increment()
        }
        if (winningLottoCheck == 5 && bonusNumberCheck) {
            LottoRank.FIVE_MATCH_WITH_BONUS.increment()
        }
        if (winningLottoCheck == 6) {
            LottoRank.SIX_MATCH.increment()
        }
    }

    fun calculateProfitPercentage(purchaseAmount: Double): Double {
        val threeMatch = LottoRank.THREE_MATCH.getCount()
        val fourMatch = LottoRank.FOUR_MATCH.getCount()
        val fiveMatch = LottoRank.FIVE_MATCH.getCount()
        val fiveWithBonusMatch = LottoRank.FIVE_MATCH_WITH_BONUS.getCount()
        val sixMatch = LottoRank.SIX_MATCH.getCount()
        val totalMoney =
            (threeMatch * THREE_MATCH_WINNING_AMOUNT) + (fourMatch * FORE_MATCH_WINNING_AMOUNT) + (fiveMatch * FIVE_MATCH_WINNING_AMOUNT) + (fiveWithBonusMatch * FIVE_WITH_BONUS_MATCH_WINNING_AMOUNT) + (sixMatch * SIX_MATCH_WINNING_AMOUNT).toDouble()
        return (totalMoney / purchaseAmount) * 100.00
    }

    fun convertStringToList(enterWinningNumbers: String): List<Int> {
        return enterWinningNumbers.split(",").map { it.trim().toInt() }
    }
}