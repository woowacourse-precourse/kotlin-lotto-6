package lotto

import lotto.utils.LottoNumbersGenerator

class LottoGameManager {
    private lateinit var lottoGame: LottoGame
    private var lottoInputHandler : LottoInputHandler

    init {
        lottoInputHandler = LottoInputHandler()
    }

    fun startLottoGame(){
        println("구입금액을 입력해 주세요.")
        val lottoAmount = receiveLottoAmount()
        val lottos = publishLottos(lottoAmount)

        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = receiveWinningNumbers()

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = receiveBonusNumber()
        lottoGame = LottoGame(lottos, winningNumbers, bonusNumber)
    }

    private fun publishLottos(lottoAmount : Int) : List<Lotto>{
        val lottos = mutableListOf<Lotto>()
        println("\n${lottoAmount}개를 구매했습니다.")
        repeat(lottoAmount){
            val lotto = Lotto(LottoNumbersGenerator.generateLottoNumbers())
            lotto.printNumbers()
            lottos.add(lotto)
        }
        return lottos
    }
    private fun receiveLottoAmount() : Int = lottoInputHandler.receiveLottoCost() / 1000

    private fun receiveWinningNumbers() : List<Int> = lottoInputHandler.receiveLottoWinningNumbers()

    private fun receiveBonusNumber() : Int = lottoInputHandler.receiveLottoBonusNumber()
}