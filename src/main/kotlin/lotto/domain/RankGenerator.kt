package lotto.domain

import lotto.domain.model.*
import lotto.util.Constants

object RankGenerator {

    private const val RESULT_FORMAT = "%d개 일치 (%s원) - %d개 "
    private const val BONUS_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개 "

    fun make(lottos: Lottos, winningLotto: WinningLotto): String {
        val lottoResult = getLottoResults(lottos, winningLotto)
        return makeReport(lottoResult)
    }

    private fun checkLotto(lotto: Lotto, winningLotto: WinningLotto) =
        Rank.getPlace(lotto.compareWinningLotto(winningLotto.winningNumbers), lotto.hasBonusNumber(winningLotto))

    fun getLottoResults(lottos: Lottos, winningLotto: WinningLotto): LottoResult {
        return lottos.lottos.map { checkLotto(it, winningLotto) }
            .groupingBy { it }
            .eachCount()
            .let { LottoResult(it) }
    }

    private fun makeReport(lottoResult: LottoResult): String {
        var report = ""
        val rankResult = Rank.getList()
        rankResult.forEach {
            report += when (it.hasBonusNumber) {
                true -> getFormat(lottoResult, it, BONUS_RESULT_FORMAT)
                false -> getFormat(lottoResult, it, RESULT_FORMAT)
            }
            report += Constants.SPACING
        }
        return report
    }

    private fun getFormat(lottoResult: LottoResult, rank: Rank, rankFormat: String): String {
        return rankFormat.format(
            rank.maxMatchWinningNumber,
            rank.prize,
            if (lottoResult.result[rank] == null) 0 else lottoResult.result[rank],
        )
    }
}
