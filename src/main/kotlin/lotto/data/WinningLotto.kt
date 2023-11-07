package lotto.data

import lotto.domain.Validator

class WinningLotto(
    val numbers: List<Int>,
    val bonus: Int,
) : Lotto(numbers) {

    init {
        Validator.getInstance().checkInputOfBonusCorrect(bonus, numbers)
    }
}