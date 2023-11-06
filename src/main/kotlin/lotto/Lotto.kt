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

    fun compareToWinningLotto(winningLotto: Lotto):Int {
        var matchedCount = 0
        for(number in numbers) {
            if(winningLotto.numbers.contains(number)) {
                matchedCount++
            }
        }
        return matchedCount
    }







}
