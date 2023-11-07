package domain.lotto

import camp.nextstep.edu.missionutils.Randoms

class NumberPicker(private val times: Int) {

    fun getRandomNumbers(): MutableList<MutableList<Int>> {
        val currentPurchasedLotties = mutableListOf<MutableList<Int>>()

        for (i in 1..times) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            currentPurchasedLotties.add(numbers)
        }

        return currentPurchasedLotties
    }

}