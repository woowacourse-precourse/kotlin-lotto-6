package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.LOTTO_RANGE_END
import lotto.util.Constants.LOTTO_RANGE_START
import lotto.util.Constants.LOTTO_SIZE
import lotto.util.Constants.ZERO_NUM

class LottoPublisher {

    val publishedLottoList: List<List<Int>>
        get() = _publishedLottoList

    private lateinit var _publishedLottoList: MutableList<List<Int>>
    private var _publishedLotto = List<Int>(LOTTO_SIZE) { ZERO_NUM }


    private fun publishLotto(): List<Int> {
        _publishedLotto = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_SIZE).sorted()
        return _publishedLotto
    }

    fun publishLottoList(times: Int): MutableList<List<Int>> {
        _publishedLottoList = MutableList(times) { _publishedLotto }
        repeat(times) { _publishedLottoList[it] = publishLotto() }
        return _publishedLottoList
    }
}