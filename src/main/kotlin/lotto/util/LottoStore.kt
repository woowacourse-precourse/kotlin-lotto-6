package lotto.util

import camp.nextstep.edu.missionutils.Randoms

//  로또를 발행해주는 로또 상점
class LottoStore : Store {
    override fun buy(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6 // 로또 번호 갯수는 6개
        const val LOTTO_TICKET_PRICE = 1000 // 로또 가격
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }
}