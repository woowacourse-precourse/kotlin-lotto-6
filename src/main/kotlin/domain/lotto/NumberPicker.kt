package domain.lotto

import camp.nextstep.edu.missionutils.Randoms

class NumberPicker(private val times: Int) {

    var pickedLotties: List<List<Int>>

    init {
        pickedLotties = getRandomNumbers()
    }

    fun getRandomNumbers(): List<List<Int>> {
        val currentPurchasedLotties = mutableListOf<List<Int>>()

        repeat(times) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            currentPurchasedLotties.add(numbers)
        }

        return sortRandomNumbers(currentPurchasedLotties)
    }

    fun sortRandomNumbers(purchasedLotties: MutableList<List<Int>>): List<List<Int>> {
        return purchasedLotties.map {
            it.sorted()
        }
    }
}