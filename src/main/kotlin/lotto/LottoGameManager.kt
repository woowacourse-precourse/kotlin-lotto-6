package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class LottoGameManager {
    private var gameState = BUYING
    private var gameManagerState = NORMAL
    private var data: Any = ""
    private var userMoney = 0

    fun set(gameState: LottoGameState) {
        this.gameState = gameState

        commandByGameState()
    }

    fun getState() = this.gameManagerState

    fun getData() = this.data

    private fun commandByGameState() {
        if (gameState == BUYING) commandBuyingState()
        // TODO: 나머지 state 구현
    }

    private fun commandBuyingState() {
        when (gameManagerState) {
            NORMAL, REQUEST_ERROR -> requestBuyingLotto()
            REQUEST -> buyLotto()
            RESULT -> finishBuyingLotto()
        }
    }

    private fun requestBuyingLotto() {
        gameManagerState = REQUEST
    }

    private fun buyLotto() {
        getMoneyFromUser()
        if (gameManagerState != REQUEST_ERROR) {
            gameManagerState = RESULT
        }
    }

    private fun finishBuyingLotto() {
        gameManagerState = NORMAL
    }

    private fun getMoneyFromUser() {
        val input = Console.readLine()

        try {
            userMoney = validatedInputAsMoney(input)
        } catch (e: IllegalArgumentException) {
            data = e
            gameManagerState = REQUEST_ERROR
        }
    }

    private fun validatedInputAsMoney(input: String): Int {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkIsNumeric(input)
        InputValidator.checkDividedAsThousand(input)
        InputValidator.checkIsNotZero(input)

        return input.toInt()
    }
}