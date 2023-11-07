package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LottoConstant
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.util.FormatUtil

object LottoService {

    fun calculateLottoCount(purchaseAmount: Int): Int {
        return purchaseAmount / LottoConstant.LOTTO_PRICE
    }

    fun generateLottos(lottoCount: Int) = List(lottoCount) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_MIN,
                LottoConstant.LOTTO_MAX,
                LottoConstant.LOTTO_SIZE
            ).sorted()
        )
    }

    fun calculateResult(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        return lottos.mapNotNull { lotto ->
            Rank.findRankByMatchCountAndBonus(
                countMatchingNumbers(lotto, winningNumbers),
                hasBonusNumber(lotto, bonusNumber)
            )
        }.groupingBy { it }.eachCount()
    }

    private fun countMatchingNumbers(lotto: Lotto, winningNumbers: List<Int>): Int {
        return lotto.getNumbers().intersect(winningNumbers.toSet()).size
    }

    private fun hasBonusNumber(lotto: Lotto, bonusNumber: Int) = lotto.getNumbers().contains(bonusNumber)

    fun calculateEarningRate(result: Map<Rank, Int>, purchaseAmount: Int): String {
        val totalReward = result.entries.sumOf { (rank, count) -> rank.reward * count }
        val earningRate = totalReward.toDouble() / purchaseAmount * 100
        return FormatUtil.formatEarningRate(earningRate)
    }
}