package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printPurchaseAmountInputMention()
        val purchasePrice = inputView.inputPurchaseAmount()

        val purchaseNumber = purchasePrice / 1000

        val tmpLottoList = mutableListOf<Lotto>()

        for (i in 0 until purchaseNumber) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val tmpLotto = Lotto(numbers)
            tmpLottoList.add(tmpLotto)
        }

        val lottoList: List<Lotto> = tmpLottoList

        outputView.printPurchaseNumber(purchaseNumber)
        for (i in 0 until purchaseNumber) {
            println(lottoList[i].getLottoNumberString())
        }

        outputView.printWinningNumberInputMention()
        val winningNumbers = inputView.inputWinningNumberList()

        outputView.printBonusNumberInputMention()
        val bonusNumber = inputView.inputBonusNumber()

        outputView.printWinningStatisticsMention()

        val winningList = HashMap<Int, Int>()
        val winningPrice = listOf<String>("0", "2,000,000,000", "30,000,000", "1,500,000", "50,000", "5,000")
        val winningPriceInt = listOf<Int>(0, 2000000000, 30000000, 1500000, 50000, 5000)
        for (i in 0..<6) winningList[i] = 0

        lottoList.forEach {
            winningList[it.getRank(winningNumbers, bonusNumber)] =
                winningList.getValue(it.getRank(winningNumbers, bonusNumber)) + 1
        }

        for (i in 5 downTo 1) {
            println("${i}개 일치 (${winningPrice[i]}원) - ${winningList[i]}개")
        }

        var totalWinningPrice = 0.0

        for (i in 1..<6) {
            totalWinningPrice += winningPriceInt[i] * winningList[i]!!
        }

        val rate = totalWinningPrice / (10 * purchaseNumber)

        outputView.printProfitRate(rate)
    }
}