package lotto

import camp.nextstep.edu.missionutils.Console

class LottoController {
    private var cost = 0

    fun start() {

    }

    fun checkLottoCost(cost: Int) {
        if (cost % 1000 != 0) {
            throw IllegalArgumentException("1000단위로 입력해 주세요.")
        }
        if (cost <= 0) {
            throw IllegalArgumentException("0을 초과한 값을 입력해 주세요.")
        }
    }
    fun inputLottoCost() {
        val inputCost = Console.readLine()
        val cost = inputCost.toInt()
        try {
            checkLottoCost(cost)
            this.cost = cost
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 알맞은 금액을 입력해주세요.")
            inputLottoCost()
        }
    }

    fun lottoGenerate() {

    }

    fun inputWinningNumber() {

    }

    fun inputPlusNumber() {

    }

    fun checkWin() {

    }


}