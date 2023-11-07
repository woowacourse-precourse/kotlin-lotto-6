package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants.COUNT
import lotto.Constants.END
import lotto.Constants.PRICE
import lotto.Constants.PURCHASED
import lotto.Constants.START

class Purchase() {
    fun lottoNum(amount: Int): MutableList<List<Int>> {
        val quantity = amount / PRICE
        println("\n${quantity}" + PURCHASED)
        return randomNum(quantity)
    }

    private fun randomNum(quantity: Int): MutableList<List<Int>> {
        val clientNum = mutableListOf<List<Int>>()
        for (i in 0 until quantity) {
            clientNum.add(Randoms.pickUniqueNumbersInRange(START, END, COUNT).sorted())
            println(clientNum[i])
        }
        return clientNum
    }
}