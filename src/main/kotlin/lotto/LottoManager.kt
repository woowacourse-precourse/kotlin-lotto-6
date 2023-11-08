package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoManager {

    private val _lottoes = mutableListOf<Lotto>()
    val lottoes: List<Lotto>
        get() = _lottoes

    fun createLottoes(price: Int) {
        val lottoNumbers = price / 1000
        repeat(lottoNumbers) {
            _lottoes.add(Lotto(getLotto()))
        }
    }

    private fun getLotto(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun printLottoes(price: Int) {
        val lottoNumbers = price / 1000
        println("${lottoNumbers}개를 구매했습니다.")
        lottoes.forEach { lotto ->
            lotto.printLotto()
        }
        println()
    }
}