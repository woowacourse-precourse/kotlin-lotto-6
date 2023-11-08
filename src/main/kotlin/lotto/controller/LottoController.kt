package lotto.controller

import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.PurchaseAmount
import lotto.model.WinningLotto
import lotto.util.HandleException
import lotto.util.UserLottosGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val handleException: HandleException) {
    fun run() {
        val purchaseAmount: PurchaseAmount = handleException.tryUntilSuccess {receiveAmount()}
        val userLottos: Lottos = issueLottos(purchaseAmount.lottoCnt)

        printPurchasedLotto(purchaseAmount.lottoCnt, userLottos)

        val winningLotto: WinningLotto = receiveWinningLotto()
    }

    private fun receiveAmount() : PurchaseAmount {
        outputView.outputAmount()
        return PurchaseAmount(inputView.inputAmount())
    }

    private fun issueLottos(lottoCnt: Int) : Lottos {
        val userLottoGenerator = UserLottosGenerator()
        return Lottos(userLottoGenerator.generate(lottoCnt))
    }

    private fun printPurchasedLotto(lottoCnt: Int, userLottos: Lottos) {
        outputView.outputLottos(lottoCnt, userLottos)
    }

    private fun receiveWinningLotto() : WinningLotto {
        val winningNums : Lotto = handleException.tryUntilSuccess { receiveWinningNums() }
        val bonusNum : Int = handleException.tryUntilSuccess { receiveBonusNum() }
        return WinningLotto(winningNums, bonusNum)
    }

    private fun receiveWinningNums(): Lotto {
        outputView.outputWinningNums()
        return Lotto(inputView.inputWinningNums())
    }

    private fun receiveBonusNum(): Int {
        outputView.outputBonusNum()
        return inputView.inputBonusNum()
    }
}