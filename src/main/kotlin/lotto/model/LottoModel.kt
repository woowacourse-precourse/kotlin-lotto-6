package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.enums.LottoResult

class LottoModel {
    private val winningAndBonusNumbers = mutableListOf<String>()
    private val lottoNumbers = mutableListOf<List<Int>>()
    private val results = mutableMapOf(
        LottoResult.MATCH_THREE to 0,
        LottoResult.MATCH_FOUR to 0,
        LottoResult.MATCH_FIVE to 0,
        LottoResult.MATCH_FIVE_BONUS to 0,
        LottoResult.MATCH_SIX to 0
    )

    fun generateLottoNumbers(amount: Int) {
        repeat(calculateLottoCount(amount)) { lottoNumbers.add(createRandomNumber()) }
    }

    fun getLottoNumbers(): MutableList<List<Int>>{
        return lottoNumbers
    }

    private fun calculateLottoCount(amount: Int): Int {
        return amount / 1000
    }

    fun setWinningNumbers(winningNumbers: String) {
        winningNumbers
            .split(",")
            .forEach { winningAndBonusNumbers.add(it) }
    }

    fun setBonusNumbers(winningBonusNumbers: String) {
        winningAndBonusNumbers.add(winningBonusNumbers)
    }

    fun calculateLotto(): MutableMap<LottoResult, Int> {
        val winningNumbers = winningAndBonusNumbers.take(6)
        val bonusNumber = winningAndBonusNumbers.last().toInt()

        lottoNumbers.forEach { lottoNumber ->
            val matchNumber = lottoNumber.intersect(winningNumbers.map { it.toInt() }.toSet()).toList()
            val match = when (matchNumber.size) {
                3 -> LottoResult.MATCH_THREE
                4 -> LottoResult.MATCH_FOUR
                5 -> if (lottoNumber.contains(bonusNumber)) LottoResult.MATCH_FIVE_BONUS else LottoResult.MATCH_FIVE
                6 -> LottoResult.MATCH_SIX
                else -> LottoResult.NOT_MATCH
            }
            results[match]?.let { results[match] = it + 1 }
        }

        return results
    }

    fun calculatorProfit(): Double {
        val totalPrize = results.map { it.key.prizeAmount * it.value }.sum()
        val amount = lottoNumbers.size * 1000
        val profitPercentage = (((totalPrize).toDouble() / amount) * 100)

        return Math.round(profitPercentage * 10.0) / 10.0
    }

    fun getWinningNumber(): List<String> {
        return winningAndBonusNumbers
    }

    private fun createRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}