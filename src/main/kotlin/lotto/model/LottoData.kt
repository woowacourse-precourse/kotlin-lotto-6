package lotto.model

import lotto.resources.Lotto.INIT_VALUE

data class LottoData(
    val winningNumbers: List<Int> = emptyList(),
    val lotteries: List<List<Int>> = emptyList(),
    val purchaseAmount: Int = INIT_VALUE,
    val bonusNumber: Int = INIT_VALUE,
    val lottoResults: List<LottoResult> = LottoWinnerInfo.entries.map { LottoResult(it) }
)