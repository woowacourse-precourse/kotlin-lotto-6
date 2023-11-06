package lotto

import lotto.io.UserInterface

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().size)
    }

    fun showNumbers() {
        val ui = UserInterface()
        ui.printLotto(numbers)
    }







}
