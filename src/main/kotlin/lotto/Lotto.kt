package lotto

import output.UserInterface

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException(UserInterface.NOT_INPUT_SAME_NUMBER_EXCEPTION.mention)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
