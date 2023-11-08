package lotto.model

import lotto.model.Lotto

data class WinningLotto(
    val numbers: Lotto,
    val bonusNumber:Int
)
