package lotto

import lottoView.LottoOutPut
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput

class LottoConroller {
    val lottoOutput = LottoOutPut()
    fun printDefaultMent() {
        lottoOutput.startMent()
        val validInput = ValidInput()
        val purchaseAmount = try {
            validInput.validInputPurchase()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return printDefaultMent()
        }
        lottoOutput.purchaseDetailPrint(purchaseAmount)
        val createNumbers = CreateNumbers()
        val lotto = Lotto(createNumbers.createRandomNumbers())
        lotto.lottoNumbersPrint(purchaseAmount)
    }
    fun printWinningMents(){
        try{
            val winningNumbers = ValidInput().validWinningNumbers(ValidInput().convertWinningNumbers())
            val bonusNumber = ValidInput().bringBonusNumber(winningNumbers)
            lottoOutput.printlnWinningNumber()
            lottoOutput.printlnBonusNumberMent()
        }
        catch (e:IllegalArgumentException){
            println(e.message)
            return printWinningMents()
        }
    }
}