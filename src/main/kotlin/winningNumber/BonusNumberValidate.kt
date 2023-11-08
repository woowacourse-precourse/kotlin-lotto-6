package winningNumber

import output.UserInterface

class BonusNumberValidate {
    fun checkBonusNumber(input: String, winningNumbers: MutableList<String>) {
        checkNumberRange(input)
        checkNumberSize(input)
        checkSameNumber(input, winningNumbers)
    }

    private fun checkNumberRange(input: String) {
        val inputNumber = input.toInt()

        if (1 > inputNumber || inputNumber > 45)
            throw IllegalArgumentException(UserInterface.UNDER_AND_OVER_NUMBER_EXCEPTION.mention)
    }

    private fun checkNumberSize(input: String) {
        if (input.indexOf(",") != -1)
            throw IllegalArgumentException(UserInterface.INPUT_BONUS_NUMBER_SIZE_NOT_1_EXCEPTION.mention)
    }

    private fun checkSameNumber(input: String, winningNumbers: MutableList<String>) {
        for (number in 0 until winningNumbers.size) {
            if (winningNumbers[number] == input)
                throw IllegalArgumentException(UserInterface.NOT_INPUT_SAME_NUMBER_EXCEPTION.mention)
        }
    }
}