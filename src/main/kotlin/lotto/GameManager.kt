package lotto

import camp.nextstep.edu.missionutils.Randoms

class GameManager(val printManager: PrintManager) {
    fun playGame(lottos: List<Lotto>, winningNumber: Lotto, bonusNumber: Int) {
        // winningNumber와 lottos 비교

    }

    fun makeLottosByMoney(money: Int): List<Lotto> {
        val lottoNumber = getLottoNumberByMoney(money)
        printManager.printLottoNumber(lottoNumber)
        return makeLottos(lottoNumber)
    }

    private fun getLottoNumberByMoney(money: Int): Int = money / 1000

    private fun makeLottos(lottoNumber: Int) : List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoNumber) {
            val lotto = Lotto(getRandomNumbers().sorted())
            lottos.add(lotto)
        }
        printManager.printLotto(lottos)
        return lottos
    }

    private fun getRandomNumbers() = Randoms.pickUniqueNumbersInRange(MIN_IN_RANGE, MAX_IN_RANGE, LOTTO_SIZE)

    companion object {
        const val MIN_IN_RANGE = 1
        const val MAX_IN_RANGE = 45
        const val LOTTO_SIZE = 6
    }
}