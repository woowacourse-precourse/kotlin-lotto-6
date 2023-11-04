package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.utils.Constant.LOTTO_COST
import lotto.utils.Constant.LOTTO_SIZE
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER

class LottoGameImpl : LottoGame {

    override fun getQuantity(purchaseAmount: Int): Int = purchaseAmount / LOTTO_COST

    override fun createRandomLottoNumbers(quantity: Int): List<Lotto> = List(quantity) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_SIZE,
            ).sorted()
        )
    }

}