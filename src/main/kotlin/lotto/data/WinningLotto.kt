package lotto.data

import lotto.domain.Validator

class WinningLotto(
    private val numbers: List<Int>,
    private val bonus: Int,
) : Lotto(numbers) {

    init {
        Validator.getInstance().checkInputOfBonusCorrect(bonus, numbers)
    }
}