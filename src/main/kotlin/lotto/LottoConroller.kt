package lotto

import lottoView.LottoOutPut
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput

class LottoConroller {
    val lottoOutput = LottoOutPut()
    fun printDefaultMent() {
        val validInput = ValidInput()
        lottoOutput.startMent()
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
            lottoOutput.printlnWinningNumber()
        }
        catch (e:IllegalArgumentException){
            println(e.message)
            return printWinningMents()
        }
        lottoOutput.printlnBonusNumberMent()
    }
}