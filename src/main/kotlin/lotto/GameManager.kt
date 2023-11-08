package lotto

import camp.nextstep.edu.missionutils.Randoms

class GameManager(val printManager: PrintManager) {
    fun playGame(lottos: List<Lotto>, winningNumber: Lotto, bonusNumber: Int) {
        val winningResult = compareLottos(lottos, winningNumber, bonusNumber)
        printManager.printResult(winningResult)
    }

    private fun compareLottos(lottos: List<Lotto>, winningNumber: Lotto, bonusNumber: Int): List<Int> {
        val countDuplicationNums = MutableList(CountDuplicationNumIndex.entries.size) { 0 }

        lottos.forEach { lotto ->
            val count = lotto.countDuplicateNumbers(winningNumber)
            val countIndex = when (count) {
                0 -> CountDuplicationNumIndex.ZERO
                1 -> CountDuplicationNumIndex.ONE
                2 -> CountDuplicationNumIndex.TWO
                3 -> CountDuplicationNumIndex.THREE
                4 -> CountDuplicationNumIndex.FOUR
                5 -> if (lotto.contains(bonusNumber)) CountDuplicationNumIndex.FIVE_BONUS else CountDuplicationNumIndex.FIVE
                6 -> CountDuplicationNumIndex.SIX
                else -> throw IllegalArgumentException("Invalid count: $count")
            }
            countDuplicationNums[countIndex.ordinal]++
        }

        return countDuplicationNums
    }

    fun makeLottosByMoney(money: Int): List<Lotto> {
        val lottoNumber = getLottoNumberByMoney(money)
        printManager.printLottoNumber(lottoNumber)
        return makeLottos(lottoNumber)
    }

    private fun getLottoNumberByMoney(money: Int): Int = money / 1000

    private fun makeLottos(lottoNumber: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoNumber) {
            val lotto = Lotto(getRandomNumbers().sorted())
            lottos.add(lotto)
        }
        printManager.printLotto(lottos)
        return lottos
    }

    fun getRandomNumbers() = Randoms.pickUniqueNumbersInRange(MIN_IN_RANGE, MAX_IN_RANGE, LOTTO_SIZE)

    companion object {
        const val MIN_IN_RANGE = 1
        const val MAX_IN_RANGE = 45
        const val LOTTO_SIZE = 6
    }
}