package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    val LOTTO_DIGIT = 6
    val LOTTO_MAX_NUM = 45
    private var cost = 0
    var lottoCollection = LottoCollection()
    val lottoView = LottoView()

    fun start() {
        inputLottoCost()
        lottoGenerate(cost/1000)
        lottoView.showGenerateLotto(lottoCollection)
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
        println("구입금액을 입력해 주세요.")
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


    fun generateNumbers(): List<Int> {
        val numberCollection: MutableList<Int> = mutableListOf()
        while (numberCollection.size < LOTTO_DIGIT) {
            val randNum = Randoms.pickNumberInRange(1, LOTTO_MAX_NUM)
            if (!numberCollection.contains(randNum)) {
                numberCollection.add(randNum)
            }
        }
        return numberCollection
    }

    fun lottoGenerate(lottoCount: Int) {
        for (i in 0 until lottoCount) {
            val randNums = generateNumbers()
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