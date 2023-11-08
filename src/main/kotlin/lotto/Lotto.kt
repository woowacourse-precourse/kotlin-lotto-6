package lotto

import lotto.view.Input

class Lotto(private val numbers: List<Int>) {
    val money = Input().inputMoney()

    init {
        require(numbers.size == 6)
    }
}

