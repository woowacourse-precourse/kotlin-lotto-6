package lotto.view

import lotto.LottoRank
import lotto.model.LottoResult

class LottoResultView {
    private var lottoResult: LottoResult = LottoResult(mapOf(), 0.0f)

    fun update(lottoResult: LottoResult) {
        this.lottoResult = lottoResult
        show()
    }

    private fun show() {
        println(
            """
            당첨 통계
            ---
            3개 일치 (5,000원) - ${lottoResult.rankCounts.getOrDefault(LottoRank.FIFTH, 0)}개
            4개 일치 (50,000원) - ${lottoResult.rankCounts.getOrDefault(LottoRank.FOURTH, 0)}개
            5개 일치 (1,500,000원) - ${lottoResult.rankCounts.getOrDefault(LottoRank.THIRD, 0)}개
            5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResult.rankCounts.getOrDefault(LottoRank.SECOND, 0)}개
            6개 일치 (2,000,000,000원) - ${lottoResult.rankCounts.getOrDefault(LottoRank.FIRST, 0)}개
            총 수익률은 ${lottoResult.earningsRate}%입니다.
        """.trimIndent()
        )
    }

}