package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants.LOTTO_SIZE
import lotto.constants.Constants.MAX_NUM
import lotto.constants.Constants.MIN_NUM

class NumberPicker(private val times: Int) {

    fun getRandomNumbers(): MutableList<MutableList<Int>> {
        val currentPurchasedLotties = mutableListOf<MutableList<Int>>()

        for (i in 1..times) {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_SIZE)
            currentPurchasedLotties.add(numbers)
        }

        return currentPurchasedLotties
    }

}