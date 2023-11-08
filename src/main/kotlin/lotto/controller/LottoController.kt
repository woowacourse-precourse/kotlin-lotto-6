package lotto.controller

import lotto.controller.ErrorHandler.repeatInputIncorrect
import lotto.domain.RandomLottoGenerator
import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.LottoResults
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.InputView.LOTTO_PRICE
import lotto.view.OutputView

class LottoController {
    private var purchaseMoney = 0
    private lateinit var randomLottos: Lottos
    private lateinit var lottoPrizes: List<LottoPrize>

    fun playGame() {
        buyLotto()
        receiveWinningNumbers()
        gameEnd()
    }

    private fun buyLotto() {
        purchaseMoney = repeatInputIncorrect { InputView.getPurchaseMoney() }
        val purchaseCount = purchaseMoney / LOTTO_PRICE
        randomLottos = Lottos(purchaseCount, RandomLottoGenerator())

        val lottosState = randomLottos.getLottosState()
        OutputView.printLottoCount(purchaseCount)
        lottosState.forEach { lottoState ->
            OutputView.printLottoNumbers(lottoState.lotto.getLottoNumbers().map { it.number })
        }
    }

    private fun receiveWinningNumbers() {
        val winningNumbers = repeatInputIncorrect { InputView.getWinningNumbers() }
        val bonusLottoNumber = repeatInputIncorrect { InputView.getBonusNumber(winningNumbers) }

        lottoPrizes = randomLottos.getLottoPrizes(Lotto(winningNumbers), bonusLottoNumber)
    }

    private fun gameEnd() {
        val lottoResults = LottoResults(lottoPrizes)
        val lottoResultsState = lottoResults.getResultState()
        OutputView.printResult()
        lottoResultsState.forEach {
            OutputView.printLottoWin(it.prizeCount, it.money, it.bonus, it.resultCount)
        }
        OutputView.printResultRate(lottoResults.totalMoney, purchaseMoney)
    }
}