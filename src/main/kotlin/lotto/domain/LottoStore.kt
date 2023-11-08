package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constant.LOTTO_NUMBER_SIZE
import lotto.utils.Constant.LOTTO_PRICE
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER

object LottoStore {
    fun issueNumbers(money: Int): List<Lotto> {
        val issuedLotto = mutableListOf<Lotto>()

        val quantity = money.div(LOTTO_PRICE)
        repeat(quantity) {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
                .map { LottoNumber(it) }
            issuedLotto.add(Lotto(numbers))
        }
        return issuedLotto
    }

}