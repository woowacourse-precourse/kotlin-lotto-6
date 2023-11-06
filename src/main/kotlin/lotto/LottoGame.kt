package lotto

import camp.nextstep.edu.missionutils.Randoms

enum class WinningPrice(val correspondResult: String, val price: Int) {
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000),
    ZERO("3개 미만 일치", 0)
}

class LottoGame {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var purchasePrice: Int = 0
    private var purchaseNumber: Int = 0
    private lateinit var lottoList: List<Lotto>
    private lateinit var winningNumberList : List<Int>
    private var bonusNumber : Int = 0


    fun start() {
        lottoPurchase()
        winningNumberList = getWinningNumberList()
        bonusNumber = getBonusNumber(winningNumberList)
        printStatistics()
    }

    private fun lottoPurchase() {
        purchasePrice = getPurchasePrice()
        purchaseNumber = purchasePrice / 1000
        lottoList = getLottoList(purchaseNumber)

        printPurchaseLottoResult(purchaseNumber, lottoList)
    }

    private fun printStatistics(){
        outputView.printWinningStatisticsMention()

        val winningList: HashMap<Int, Int> = getWinningList(lottoList, winningNumberList, bonusNumber)
        outputView.printWinningStatics(winningList)

        val totalWinningPrice = getTotalPrice(winningList)
        val rate = totalWinningPrice / (10 * purchaseNumber)

        outputView.printProfitRate(rate)
    }

    private fun getPurchasePrice(): Int {
        outputView.printPurchaseAmountInputMention()
        return inputView.inputPurchaseAmount()
    }

    private fun getLottoList(purchaseNumber: Int): List<Lotto> {
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

    private fun getWinningNumberList(): List<Int> {
        outputView.printWinningNumberInputMention()
        return inputView.inputWinningNumberList()
    }

    private fun getBonusNumber(winningNumberList: List<Int>): Int {
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

    private fun getWinningPrice(rank: Int): WinningPrice {
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