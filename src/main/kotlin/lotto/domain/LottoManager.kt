package lotto.domain

import lotto.data.LottoNums
import lotto.data.LottoResult
import lotto.ui.LottoCustomerScreen
import lotto.ui.LottoManagerScreen

class LottoManager {

    private var lottoCounts = 0
    private var lottoAmount = 0
    private var lottoNumsList = emptyList<List<Int>>()
    private  var lottoNums : LottoNums
    private var lottoResult : LottoResult
    private var revenue : Float

    init {
        val customer = Customer()

        lottoAmount = customer.getPurchaseAmounts()
        lottoCounts = customer.getPurchaseCounts()
        lottoNumsList = customer.lottoNumsList

        val lottoCustomerScreen = LottoCustomerScreen(lottoCounts,lottoNumsList)
        lottoCustomerScreen.printLottoNumsList()

        val inputManager = LottoInputManager()
        lottoNums = inputManager.getLottoNums()

        val outputManager = LottoOutputManager(lottoNumsList,lottoNums)
        outputManager.calculateRevenue(lottoAmount)
        lottoResult = outputManager.getResult()
        revenue = outputManager.getRevenue()

        val lottoManagerScreen = LottoManagerScreen(lottoResult,revenue)


    }




}