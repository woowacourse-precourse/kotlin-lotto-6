package lotto

import lotto.utils.LottoNumbersGenerator

class LottoGame(private val lottoAmount : Int) {
    private var lottos: MutableList<Lotto> = mutableListOf()

    init {
        publishLotto()
    }

    private fun publishLotto() {
        println("${lottoAmount}개를 구매했습니다.")
        repeat(lottoAmount){
            val lotto = Lotto(LottoNumbersGenerator.generateLottoNumbers())
            lottos.add(lotto)
        }
    }
}