package winningNumber

import output.UserInterface

class WinningNumberValidate {

    fun checkWinningNumber(input: List<String>) {
        checkNumberSize(input)
        checkNumberSpace(input)
        checkSameNumber(input)
        checkNumberRange(input)
    }

    private fun checkNumberSize(input: List<String>) {
        if (input.size != 6)
            throw IllegalArgumentException(UserInterface.INPUT_WINNING_NUMBER_SIZE_NOT_6_EXCEPTION.mention)
    }

    private fun checkNumberSpace(input: List<String>) {
        if (input.contains(" "))
            throw IllegalArgumentException(UserInterface.NOT_INPUT_SPACE_EXCEPTION.mention)
    }

    private fun checkSameNumber(input: List<String>) {
        val distinctNumbers = input.distinct()

        if (distinctNumbers.size != input.size) {
            throw IllegalArgumentException(UserInterface.NOT_INPUT_SAME_NUMBER_EXCEPTION.mention)
        }
    }

    private fun checkNumberRange(input: List<String>) {
        val inputOfNumber = input.map { it.toInt() }
        for (number in 0 until inputOfNumber.size) {
            if (inputOfNumber[number] < 1 || inputOfNumber[number] > 45)
                throw IllegalArgumentException(UserInterface.UNDER_AND_OVER_NUMBER_EXCEPTION.mention)

        }
    }
}