package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Sale {
    fun generateRandomNumber(): List<Int> =
        Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT)


    fun createLottoTicket(numbers: List<Int>): List<Int> = Lotto(numbers).sort()

    companion object {
        const val START_NUMBER = 1
        const val END_NUMBER = 45
        const val COUNT = 6
    }
}