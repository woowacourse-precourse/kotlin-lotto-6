package lotto.model

import lotto.data.LottoWinnerInfo
import lotto.resources.Lotto.INIT_VALUE

data class LottoResult(
    val lottoWinnerInfo: LottoWinnerInfo,
    val value: Int = INIT_VALUE
)