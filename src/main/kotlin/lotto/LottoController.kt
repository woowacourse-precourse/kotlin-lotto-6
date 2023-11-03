package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    val LOTTO_DIGIT = 6
    val LOTTO_MAX_NUM = 45
    private var cost = 0
    private var lottoCollection = LottoCollection()

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

    fun generateNumber(): MutableList<Int> {
        val numberCollection: MutableList<Int> = mutableListOf()
        for (i in 0 until LOTTO_DIGIT) {
            val randNum = Randoms.pickNumberInRange(1,LOTTO_MAX_NUM)
            numberCollection.add(randNum)
        }
        return numberCollection
    }

    fun lottoGenerate(lottoCount: Int) {
        for (i in 0 until lottoCount) {
            val randNums = generateNumber()
            val lotto = Lotto(randNums)
            lottoCollection.putLotto(lotto)
        }
    }

    fun inputWinningNumber() {

    }

    fun inputPlusNumber() {

    }

    fun checkWin() {

    }


}