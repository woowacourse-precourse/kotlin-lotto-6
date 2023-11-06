package lotto.util

import lotto.view.Message

object Check {

    fun checkMoney(money: Int?) {
        checkIntNull(money)
        //checkInt 메소드로 인해 money는 null이 아님
        checkThousandUnit(money!!)
    }

    fun checkWinningNumbers(numbers: List<Int?>) {

        for (number in numbers) {
            checkIntNull(number)
            //checkInt 메소드로 인해 number는 null이 아님
            checkInRange(number)
        }

        checkSixDifferentNumbers(numbers)
    }

    fun checkBonusNumber(number: Int?) {
        checkIntNull(number)

        checkInRange(number)
    }

    private fun checkSixDifferentNumbers(numbers: List<Int?>) {
        if (!isSixSize(numbers)) {
            throw IllegalArgumentException(Message.ERROR_SIX_DIFFERENT_NUMBERS.message)
        }
    }

    private fun checkInRange(number: Int?) {
        if (!isInRange(number!!)) {
            throw IllegalArgumentException(Message.ERROR_NUMBER_RANGE.message)
        }
    }


    private fun checkThousandUnit(input: Int) {
        if (!isThousandUnit(input)) {
            throw IllegalArgumentException(Message.ERROR_PURCHASE_PRICE.message)
        }
    }

    private fun checkIntNull(input: Int?) {
        if (!isInt(input)) {
            throw IllegalArgumentException(Message.ERROR_INT.message)
        }
    }

    private fun isThousandUnit(input: Int): Boolean = (input % 1000) == 0

    private fun isInt(input: Int?): Boolean = input != null

    private fun isInRange(input: Int): Boolean = input in MIN_NUMBER..MAX_NUMBER

    private fun isSixSize(list: List<Int?>): Boolean {
        val listToSet = list.toSet()

        return listToSet.size == LOTTO_SIZE
    }


    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val LOTTO_SIZE = 6
}