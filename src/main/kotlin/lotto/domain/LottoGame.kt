package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoMatchResult
import lotto.model.LottoResult

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