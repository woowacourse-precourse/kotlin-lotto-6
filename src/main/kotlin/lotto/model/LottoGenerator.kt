package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    private fun createLotto() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())

    fun getLottos(num: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(num) {
            lottoList.add(createLotto())
        }
        return lottoList.toList()
    }
}