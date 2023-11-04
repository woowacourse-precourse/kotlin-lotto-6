package lotto

import lotto.view.OutputView

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isDuplicate())
        OutputView().printLotto(numbers)
    }

    private fun isDuplicate() = numbers.distinct().size != numbers.size
}
