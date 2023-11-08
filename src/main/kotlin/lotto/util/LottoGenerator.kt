package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    private fun randomNumber() : List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
    fun randomLotto(cnt: Int) : MutableList<List<Int>> {
        val lottoList: MutableList<List<Int>> = mutableListOf()
        (0 until cnt).forEach{ _ ->
            val numbers = randomNumber()
            lottoList.add(numbers)
            LottoView().numbersList(numbers)
        }
        return lottoList
    }
}