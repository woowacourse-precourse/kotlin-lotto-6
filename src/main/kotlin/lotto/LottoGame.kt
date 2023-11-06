package lotto

import lotto.utils.LottoNumbersGenerator

class LottoGame(private val lottoAmount : Int) {
    private var lottos: MutableList<Lotto> = mutableListOf()
    private var winningNumbers : List<Int>

    init {
        publishLotto()
        println("\n당첨 번호를 입력해 주세요.")
        winningNumbers = receiveWinningNumbers()
    }

    private fun publishLotto() {
        println("\n${lottoAmount}개를 구매했습니다.")
        repeat(lottoAmount){
            val lotto = Lotto(LottoNumbersGenerator.generateLottoNumbers())
            lotto.printNumbers()
            lottos.add(lotto)
        }
    }

    private fun receiveWinningNumbers() = LottoInputHandler.receiveLottoWinningNumbers()
}