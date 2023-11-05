package exception

import constants.*


class Exception {

    fun noDividedThousand() {
        println(ERROR_NO_DIVIDED_BY_THOUSAND_MESSAGE)
        throw IllegalArgumentException(ERROR_NO_DIVIDED_BY_THOUSAND_MESSAGE)
    }

    fun noInteger() {
        println(ERROR_NO_INTEGER_MESSAGE)
        throw IllegalArgumentException(ERROR_NO_INTEGER_MESSAGE)
    }

    fun noCorrectWinNumber() {
        println(ERROR_WIN_NUMBER_MESSAGE)
        throw IllegalArgumentException(ERROR_WIN_NUMBER_MESSAGE)
    }

    fun noCorrectLottoNumber() {
        println(ERROR_LOTTO_NUMBER_MESSAGE)
        throw IllegalArgumentException(ERROR_LOTTO_NUMBER_MESSAGE)
    }

    fun duplicatedWinPrizeList() {
        println(ERROR_DUPLICATED_WIN_PRIZE_MESSAGE)
        throw IllegalArgumentException(ERROR_DUPLICATED_WIN_PRIZE_MESSAGE)
    }

    fun bonusInWinNumberList() {
        println(ERROR_BONUS_IN_PRIZE_LIST_MESSAGE)
        throw IllegalArgumentException(ERROR_BONUS_IN_PRIZE_LIST_MESSAGE)
    }


}