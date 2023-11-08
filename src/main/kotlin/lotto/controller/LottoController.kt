package lotto.controller

import lotto.model.LottoManager
import lotto.model.LottoStatics
import lotto.model.Validation
import lotto.view.Output
import lotto.view.UserInput
import java.lang.IllegalArgumentException

class LottoController(
    private val userInput: UserInput = UserInput(),
    private val output: Output = Output(),
) {

    private lateinit var lottoManager: LottoManager
    private lateinit var lottoStatics: LottoStatics

    fun run() {
        val purchaseAmount = buyLotto()
        val answerAmount = inputAnswerLoop()
        val bonusNum = inputBonusLoop()

        lottoStatics = LottoStatics(lottoManager)
        printResult(answerAmount, bonusNum, purchaseAmount)

    }


    private fun inputPurchaseLoop(): Int {
        while (true) {
            try {
                return Validation.getPurchaseAmount(userInput.getPurchaseAmount())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputAnswerLoop(): List<Int> {
        while (true) {
            try {
                return Validation.getAnswerNumber(userInput.getAnswerNumber())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusLoop(): Int {
        while (true) {
            try {
                return Validation.getBonusNum(userInput.getBonusNum())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun buyLotto(): Int {
        val purchaseAmount = inputPurchaseLoop()
        lottoManager = LottoManager(purchaseAmount)
        lottoManager.create()
        output.printLottoesNum(lottoManager.lottoes)
        println()
        return purchaseAmount
    }

    private fun printResult(
        answerAmount: List<Int>,
        bonusNum: Int,
        purchaseAmount: Int
    ) {
        val winStatics =
            lottoStatics.getWinStatics(answerAmount, bonusNum)
        val totalReturn = lottoStatics.getReturnRate(purchaseAmount)

        output.printWinStatics(winStatics)
        output.printTotalReturn(totalReturn)
    }

}