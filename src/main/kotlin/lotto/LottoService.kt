package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoService {
    fun buyLotto(buyCount: Int): List<Lotto> {
        val buyLottos = mutableListOf<Lotto>()
        repeat(buyCount) {
            buyLottos.add(Lotto(lottoMaker()))
        }
        return buyLottos
    }


    private fun lottoMaker(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

}
