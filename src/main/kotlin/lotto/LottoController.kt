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
    fun getWinningList(lottoList: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int):Map<Int, Int> {
        val tempMap = mutableMapOf<Int, Int>()
        for (i in 0..<6) tempMap[i] = 0

        lottoList.forEach {
          tempMap[it.getRank(winningNumbers, bonusNumber)] =
                tempMap.getValue(it.getRank(winningNumbers, bonusNumber)) + 1
        }

        return tempMap
    }

    fun getTotalPrice(winningList: Map<Int, Int>): Double {
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

