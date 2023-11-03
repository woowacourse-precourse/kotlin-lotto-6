package lotto.model

import lotto.constants.Exception

class WinningLotto(val lotto: Lotto, val bonus: Bonus) {

    init {
        require(lotto.notContains(bonus)) { Exception.DUPLICATION }
    }

}