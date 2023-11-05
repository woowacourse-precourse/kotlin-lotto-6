package lotto.model

import lotto.constants.Exception

class WinningLotto(val lotto: Lotto, val bonus: Bonus) {
    init {
        require(!lotto.isMatchingBonus(bonus)) { Exception.DUPLICATION }
    }
}