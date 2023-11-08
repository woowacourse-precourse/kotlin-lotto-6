package lotto

import lottoView.LottoOutPut
import lottoView.WinningReward
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput
class LottoController {
    private val lottoOutput = LottoOutPut()
    private val validInput = ValidInput()
    private val createNumbers = CreateNumbers()
    private var purchaseTotal: Int = 0
    private var purchaseAmount: Int = 0
    private lateinit var lottoList: List<Lotto>
    private lateinit var winningNumbers: List<Int>
    private lateinit var winningList:Map<Int,Int>
    private var bonus:Int=0
    enum class WinningRate(val message:String){
        RESULT_RATE("총 수익률은 %.1f%%입니다.")
    }
    fun printDefaultMent() {
        lottoOutput.startMent()
        purchaseAmount = getValidPurchaseAmount()
        purchaseTotal=purchaseAmount*1000
        lottoOutput.purchaseDetailPrint(purchaseAmount)
        lottoList = createNumbers.getLottoList(purchaseAmount)
        lottoOutput.printLottoList(purchaseAmount, lottoList)
    }

    fun getValidPurchaseAmount(): Int {
        return try {
            validInput.validInputPurchase()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return getValidPurchaseAmount()
        }
    }

    fun printWinningNumber(): List<Int> {
        while (true) {
            try {
                lottoOutput.printlnWiningNumberMent()
                winningNumbers = validInput.convertWinningNumbers()
                validInput.validWinningNumbers(winningNumbers)
                bonus=validInput.bringBonusNumber(winningNumbers)
                calculateMount()
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return printWinningNumber()
            }
        }
    }
    private fun calculateMount(){
       winningList=getWinningList(lottoList,winningNumbers, bonus)
        val totalWinning=getTotalPrice(winningList)
        val rate=totalWinning*10/(100*purchaseAmount)
        lottoOutput.printWinningResult(winningList)
        println(WinningRate.RESULT_RATE.message.format(rate))
    }
    private fun getWinningList(lottoList: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Int, Int> {
        val rankCounts = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)

        for (lotto in lottoList) {
            val rank = lotto.getRank(winningNumbers, bonusNumber)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
        }

        return rankCounts
    }


    private fun getTotalPrice(winningList: Map<Int, Int>): Double {
        var totalWinningPrice = 0.0
        for (i in 1..<6) {
            totalWinningPrice += getWinningPrice(i).price * winningList[i]!!
        }
        return totalWinningPrice
    }

    private fun getWinningPrice(rank: Int): WinningReward {
        return when (rank) {
            5 -> WinningReward.THREE
            4 -> WinningReward.FOUR
            3 -> WinningReward.FIVE
            2 -> WinningReward.FIVEANDBONUS
            1 -> WinningReward.SIX
            else -> WinningReward.ZERO
        }
    }

}

