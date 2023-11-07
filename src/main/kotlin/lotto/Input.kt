package lotto

import camp.nextstep.edu.missionutils.Console

object Input {
    private fun getInput(): String {
        val input = Console.readLine()
        require(input.isNotEmpty())
        return input
    }
    fun getBudget(): Int {
        val budget = getInput().toInt()
        require(budget > 0)
        require(budget % Constants.PRICE_OF_LOTTO == 0)
        return budget
    }
}