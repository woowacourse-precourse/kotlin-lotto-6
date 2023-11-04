package lotto

import camp.nextstep.edu.missionutils.Randoms

enum class WinningPrice(val rank: Int, val price: Int) {
    FIFTH(5, 5000),
    FOURTH(4, 50000),
    THIRD(3, 1500000),
    SECOND(2, 30000000),
    FIRST(1, 2000000000),
    ZERO(0, 0)
}

class LottoGame {
    companion object {
        private val inputView = InputView()
        private val outputView = OutputView()
    }

    fun start() {
        val purchasePrice = getPurchasePrice()
        val purchaseNumber = purchasePrice / 1000

        val lottoList: List<Lotto> = getLottoList(purchaseNumber)

        printPurchaseLottoResult(purchaseNumber, lottoList)

        val winningNumberList = getWinningNumberList()
        val bonusNumber = getBonusNumber(winningNumberList)

        outputView.printWinningStatisticsMention()

        val winningList: HashMap<Int, Int> = getWinningList(lottoList, winningNumberList, bonusNumber)

        outputView.printWinningStatics(winningList)

        var totalWinningPrice = getTotalPrice(winningList)
        val rate = totalWinningPrice / (10 * purchaseNumber)

        outputView.printProfitRate(rate)
    }

    fun getPurchasePrice(): Int {
        outputView.printPurchaseAmountInputMention()
        return inputView.inputPurchaseAmount()
    }

    fun getLottoList(purchaseNumber: Int): List<Lotto> {
        val tmpLottoList = mutableListOf<Lotto>()

        for (i in 0 until purchaseNumber) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val tmpLotto = Lotto(numbers)
            tmpLottoList.add(tmpLotto)
        }
        return tmpLottoList.toList()
    }

    fun printPurchaseLottoResult(purchaseNumber: Int, lottoList: List<Lotto>) {
        outputView.printPurchaseNumberMention(purchaseNumber)
        outputView.printLottoList(purchaseNumber, lottoList)
    }

    fun getWinningNumberList(): List<Int> {
        outputView.printWinningNumberInputMention()
        return inputView.inputWinningNumberList()
    }

    fun getBonusNumber(winningNumberList: List<Int>): Int {
        outputView.printBonusNumberInputMention()
        return inputView.inputBonusNumber(winningNumberList)
    }

    fun getWinningList(lottoList: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): HashMap<Int, Int> {
        val tmpWinningList = HashMap<Int, Int>()
        for (i in 0..<6) tmpWinningList[i] = 0

        lottoList.forEach {
            tmpWinningList[it.getRank(winningNumbers, bonusNumber)] =
                tmpWinningList.getValue(it.getRank(winningNumbers, bonusNumber)) + 1
        }

        return tmpWinningList
    }

    fun getTotalPrice(winningList: HashMap<Int, Int>): Double {
        var totalWinningPrice = 0.0
        for (i in 1..<6) {
            totalWinningPrice += getWinningPrice(i).price * winningList[i]!!
        }
        return totalWinningPrice
    }

    fun getWinningPrice(rank: Int): WinningPrice {
        return when (rank) {
            5 -> WinningPrice.FIFTH
            4 -> WinningPrice.FOURTH
            3 -> WinningPrice.THIRD
            2 -> WinningPrice.SECOND
            1 -> WinningPrice.FIRST
            else -> WinningPrice.ZERO
        }
    }
}