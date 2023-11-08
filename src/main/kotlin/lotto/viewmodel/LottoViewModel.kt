package lotto.viewmodel

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.observer.GenerateLottoListener
import lotto.observer.InputMoneyListener

class LottoViewModel: InputMoneyListener {
    lateinit var generateLottoListener: GenerateLottoListener
    var numberOfLotto = 0
    val lotto = mutableListOf<Lotto>()

    override fun inputMoneyListener(money: Int) {
        this.numberOfLotto = calculateNumberOfLotto(money)
        generateLotto()
        generateLottoListener.generateLotto(this.lotto)
    }

    private fun lottoGenerator(): Lotto {
        val list = numberGenerator()
        return if (list.distinct().size == 6) { Lotto(list) }
        else { lottoGenerator() }
    }

    private fun numberGenerator() = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    private fun calculateNumberOfLotto(money: Int): Int = money / 1000
    private fun generateLotto() = repeat(numberOfLotto) { this.lotto.add(lottoGenerator()) }
}