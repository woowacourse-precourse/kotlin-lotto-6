package lotto.controller

import lotto.domain.RandomLottoGenerator
import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.LottoResults
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private var purchaseMoney = 0
    private lateinit var randomLottos: Lottos
    private lateinit var lottoPrizes: List<LottoPrize?>

    fun playGame() {

        buyLotto()
        receiveWinningNumbers()
        gameEnd()
    }

    private fun buyLotto() {
        purchaseMoney = InputView.getPurchaseMoney()
        val purchaseCount = purchaseMoney / 1000
        randomLottos = Lottos(purchaseCount, RandomLottoGenerator())

        val lottoState = randomLottos.getLottoState()
        OutputView.printLottoCount(purchaseCount)
        lottoState.forEach {
            OutputView.printLottoNumbers(it.lotto)
        }
    }

    private fun receiveWinningNumbers() {
        val winningNumbers = InputView.getWinningNumber()
        val bonusLottoNumber = InputView.getBonusNumber(winningNumbers)
        lottoPrizes = randomLottos.getLottoPrizes(Lotto(winningNumbers), bonusLottoNumber)
    }

    fun gameEnd() {
        val lottoResults = LottoResults()
        lottoResults.makeLottoResults(lottoPrizes)

        val lottoResultsState = lottoResults.getResultState()
        OutputView.printResult()
        lottoResultsState.forEach {
            OutputView.printLottoWin(it.prizeCount, it.money, it.bonus, it.resultCount)
        }
        OutputView.printResultRate(lottoResults.getTotalMoney(), purchaseMoney)

    }

}