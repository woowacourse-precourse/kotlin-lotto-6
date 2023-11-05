package lotto.model.lotto

import lotto.constants.Exception
import lotto.model.Bonus

class WinningLotto(val lotto: Lotto, val bonus: Bonus) {
    init {
        require(!lotto.isMatchingBonus(bonus)) { Exception.LOTTO_DUPLICATION }
    }
}