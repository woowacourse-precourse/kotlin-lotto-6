package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoFactory {
    fun createLotto() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))

    fun createLottoByCount(count: Int) : List<Lotto>{
        val lottoList = mutableListOf<Lotto>()
        repeat(count) { lottoList.add(createLotto()) }
        return lottoList.toList()
    }
}