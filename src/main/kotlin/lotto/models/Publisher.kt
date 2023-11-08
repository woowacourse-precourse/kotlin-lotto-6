package lotto.models

import camp.nextstep.edu.missionutils.Randoms

class Publisher(private val publishingLottoCount: Int) {

    fun publishLottos(): List<Lotto> {
        val publishedLottos = mutableListOf<Lotto>()

        repeat(publishingLottoCount) {
            val lottoNumbers = generateLottoNumbers()
            val publishedLotto = Lotto(lottoNumbers)

            publishedLottos.add(publishedLotto)
        }

        return publishedLottos
    }

    private fun generateLottoNumbers() =
        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)
}