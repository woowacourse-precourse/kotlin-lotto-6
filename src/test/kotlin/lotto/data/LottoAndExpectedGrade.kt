package lotto.data

import lotto.data.GRADE
import lotto.data.Lotto

data class LottoAndExpectedGrade(
    val lotto: Lotto,
    val winningLotto: Lotto,
    val bonus: Int,
    val grade: GRADE,
)
