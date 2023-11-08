package lotto

import camp.nextstep.edu.missionutils.Randoms

class GameManager() {
    fun playGame(money: Int, winningNumbers: Lotto, bonusNumber: Int) {
        val lottoNumber = getLottoNumber(money)


    }

    private fun getLottoNumber(money: Int): Int = money / 1000

    private fun makeLottos(lottoNumber: Int) : List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoNumber) {
            lottos.add(getRandomLottoNumbers())
        }
        return lottos
    }

    private fun getRandomLottoNumbers() = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
}