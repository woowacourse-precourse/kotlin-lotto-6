package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
    }
    // TODO: 추가 기능 구현
}

class LottoGameModel(howManyBuyLotto: Int) {

    fun createLottoNumbers() : List<Int>{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }
}