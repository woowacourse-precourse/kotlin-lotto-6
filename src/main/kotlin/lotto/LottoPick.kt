package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoPick() {

    private fun randomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
    fun randomLotto(cnt: Int):MutableList<List<Int>>{
        val lottoList: MutableList<List<Int>> = mutableListOf()
        for(i in 0 until cnt){
            val numbers = randomNumber()
            lottoList.add(numbers)
            LottoView().numbersList(numbers)
        }
        return lottoList
    }

    fun pickValid(pickList: List<String>): List<Int>{
        val numbers = pickList.mapNotNull { it.toIntOrNull() }
        Lotto(numbers)
        return numbers
    }
    private fun validPickNumber(): List<Int> {
        val numbers = Console.readLine()
        val pickList = numbers.split(",")
        return pickValid(pickList)
    }
    fun pickNumber(): List<Int> {
        LottoView().pickView()
        while(true) {
            try {
                return validPickNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}