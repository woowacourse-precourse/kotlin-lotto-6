package lotto.domain

import lotto.Model.Lotto
import lotto.Model.LottoMatchResult
import lotto.Model.LottoResult

interface LottoGame {
    fun getQuantity(purchaseAmount: Int): Int

    fun createRandomLottoNumbers(quantity: Int): List<Lotto>

    fun getLottoResults(
        lottoNumbers: List<Lotto>,
        winningNumber: Lotto,
        bonusNumber: Int,
    ): List<LottoResult>

    fun getLottoMatchResult(lottoResults: List<LottoResult>): LottoMatchResult

    fun calculateRate(lottoMatchResult: LottoMatchResult, purchaseAmount: Int): Float
}