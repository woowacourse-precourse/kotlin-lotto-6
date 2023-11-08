package lotto.models

import camp.nextstep.edu.missionutils.Randoms
import lotto.models.Purchase.Companion.AMOUNT_UNIT

class Publisher {

    fun publishLottos(purchase: Purchase): List<Lotto> {
        val publishedLottos = mutableListOf<Lotto>()

        repeat(purchase.getAmount() / AMOUNT_UNIT) {
            val lottoNumbers = generateLottoNumbers()
            val publishedLotto = Lotto(lottoNumbers)

            publishedLottos.add(publishedLotto)
        }

        return publishedLottos
    }

    private fun generateLottoNumbers() =
        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)
}