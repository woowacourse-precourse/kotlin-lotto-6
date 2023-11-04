package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    val LOTTO_DIGIT = 6
    val LOTTO_MAX_NUM = 45
    private var cost = 0
    var lottoCollection = LottoCollection()
    val lottoView = LottoView()
    val winningNumbers: MutableList<Int> = mutableListOf()
    var plusNumber: Int = 0
    fun start() {
        inputLottoCost()
        println()
        lottoGenerate(cost/1000)
        lottoView.showGenerateLotto(lottoCollection)
        inputWinningNumber()
        inputPlusNumber()
        checkWin()
    }

    fun checkLottoCost(InputCost: String) {
        var cost = 0
        try {
            cost = InputCost.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("숫자를 입력해 주세요.")
        }
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
        try {
            checkLottoCost(inputCost)
            this.cost = inputCost.toInt()
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

    fun checkWinningNumbers(winningNumbers: List<Int>) {
        require(winningNumbers.size == LOTTO_DIGIT)
        require(winningNumbers.distinct().size == winningNumbers.size)
        for (number in winningNumbers) {
            require(number <= LOTTO_MAX_NUM)
            require(1 <= number)
        }
    }

    fun inputWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
        val inputWinningNumbers = Console.readLine()
        val inputCollection = inputWinningNumbers.split(",")
        winningNumbers.clear()
        for (number in inputCollection) {
            winningNumbers.add(number.toInt())
        }
        try {
            checkWinningNumbers(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 6자리의 1-45의 숫자를 입력해 주세요.")
            inputWinningNumber()
        }
        println()
    }

    fun checkPlusNumber(plusNumber: Int) {
        require(!winningNumbers.contains(plusNumber))
        require(plusNumber <= LOTTO_MAX_NUM)
        require(1 <= plusNumber)
    }

    fun inputPlusNumber() {
        println("보너스 번호를 입력해 주세요.")
        val inputPlusNumber = Console.readLine()
        plusNumber = inputPlusNumber.toInt()
        try {
            checkPlusNumber(plusNumber)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 1-45의 당첨 번호와 겹치지 않는 수자를 입력해 주세요.")
            inputPlusNumber()
        }
        println()
    }

    fun checkWin() {
        val winRankList = lottoCollection.checkWin(winningNumbers, plusNumber)
        val winRankNumList = mutableListOf(0,0,0,0,0,0)
        for (rank in winRankList) {
            winRankNumList[rank] ++
        }
        lottoView.showLottoResult(winRankNumList)
        lottoView.showLottoResultAverage(winRankNumList)
    }
}