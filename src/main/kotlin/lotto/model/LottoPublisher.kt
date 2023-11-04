package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoPublisher {

    val publishedLottoList: List<List<Int>>
        get() = _publishedLottoList

    private lateinit var _publishedLottoList: MutableList<MutableList<Int>>
    private var _publishedLotto = MutableList<Int>(LOTTO_SIZE) { INIT_NUMS }


    private fun publishLotto(): MutableList<Int> {
        _publishedLotto = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_SIZE)
        return _publishedLotto
    }

    fun publishLottoList(times: Int): MutableList<MutableList<Int>> {
        _publishedLottoList = MutableList(times) { _publishedLotto }
        repeat(times) { _publishedLottoList[it] = publishLotto() }
        return _publishedLottoList
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val INIT_NUMS = 0
        const val LOTTO_RANGE_START = 1
        const val LOTTO_RANGE_END = 45
    }
}