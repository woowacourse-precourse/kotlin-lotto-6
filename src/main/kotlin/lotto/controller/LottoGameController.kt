package lotto.controller

import lotto.model.Grade
import lotto.view.InputView
import lotto.model.Lotto
import lotto.model.Seller
import lotto.model.WinningNumber
import lotto.view.LottoResultView

class LottoGameController {
    private val seller = Seller()
    private val inputView = InputView()
    private val grade = Grade()
    private val lottoResultView = LottoResultView()

    fun startLottoGame() {
        val money = inputView.inputMoney()
        val lottoPapers = seller.sellLotto(money)

        printLotto(lottoPapers)

        val winningNumber = createWinningNumber()
        lottoPapers.forEach { myLotto ->
            grade.decideGrade(myLotto, winningNumber)
        }

        val gradeResult = grade.getLottoGradeResult()
        lottoResultView.printLottoStatistics(grade.getLottoGradeResult())
        lottoResultView.printRateReturn(gradeResult, money)
    }

    private fun createWinningNumber(): WinningNumber = WinningNumber(
        inputView.inputWinningNumber(),
        inputView.inputBonusNumber()
    )

    private fun printLotto(lottoPaper: List<Lotto>) {
        println("\n${USER_LOTTO.format(lottoPaper.size)}")
        lottoPaper.forEach { lotto ->
            lotto.printNumbers()
        }
    }

    companion object {
        private const val USER_LOTTO = "%d개를 구매했습니다."
    }
}