package lotto.dto

import lotto.model.validation.LottoNumber

data class WinningAndBonusNumbers(
    val winNums: List<LottoNumber>,
    val bonusNum: LottoNumber,
)