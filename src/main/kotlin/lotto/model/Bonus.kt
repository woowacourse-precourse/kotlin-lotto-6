package lotto.model

import lotto.constants.Exception

class Bonus(val number: Int) {
    init {
        require(number in 1..45) { Exception.RANGE }
    }
}