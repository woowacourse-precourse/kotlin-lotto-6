package lotto

import camp.nextstep.edu.missionutils.Randoms
class LottoPick {

    fun randomNumber(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
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
}