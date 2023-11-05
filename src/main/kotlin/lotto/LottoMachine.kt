package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine() {
    fun calculateNumberOfLotto(price: Int): Int = price / WON_PER_LOTTO

    fun getLottoTickets(count: Int): List<Lotto> {
        val lottoTickets: MutableList<Lotto> = mutableListOf()
        repeat(count) {
            lottoTickets.add(generateLotto(generateLottoNumbers()))
        }
        return lottoTickets
    }

    fun generateLotto(numbers: List<Int>): Lotto = Lotto(numbers.sorted())

    fun generateLottoNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(START_RANGE_LOTTO_NUM, END_RANGE_LOTTO_NUM, LOTTO_NUMBER_COUNT)

    companion object {
        const val WON_PER_LOTTO = 1000
        const val START_RANGE_LOTTO_NUM = 1
        const val END_RANGE_LOTTO_NUM = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}