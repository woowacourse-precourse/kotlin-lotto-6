package lotto.model

import lotto.data.LottoMatchInfo
import lotto.resources.Lotto.INIT_VALUE

data class LottoResult(
    val lottoMatchInfo: LottoMatchInfo,
    var value: Int = INIT_VALUE
)