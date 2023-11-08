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
        val purchaseAmount = inputPurchaseAmountLoop()
        val answerAmount = inputAnswerNumLoop()
        val bonusNum = inputBonusNumLoop()

    }


    private fun inputPurchaseAmountLoop(): Int {
        while (true) {
            try {
                return Validation.getPurchaseAmount(userInput.getPurchaseAmount())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputAnswerNumLoop(): List<Int> {
        while (true) {
            try {
                return Validation.getAnswerNumber(userInput.getAnswerNumber())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumLoop(): Int {
        while (true) {
            try {
                return Validation.getBonusNum(userInput.getBonusNum())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}