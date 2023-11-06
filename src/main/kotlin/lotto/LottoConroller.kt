package lotto

import lottoView.LottoOutPut
import lottoView.LottoWinningStatics
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
            ValidInput().bringBonusNumber(winningNumbers)
            lottoOutput.printlnWinningNumber()
            lottoOutput.printlnBonusNumberMent()
        }
        catch (e:IllegalArgumentException){
            println(e.message)
            return printWinningMents()
        }
    }
    fun calculateRank(winningNumbers:List<Int>,bonusNumber:String,purchaseLotto:List<List<Int>>){
    }
    private fun winningRank(matchNumber:Int,hasBonus:Boolean):LottoWinningStatics.NumberOfMatches{
        return when{
            matchNumber==6->LottoWinningStatics.NumberOfMatches.SIX_MATHCES
            matchNumber==5&&hasBonus->LottoWinningStatics.NumberOfMatches.FIVE_BONUS_MATCHES
            matchNumber==5->LottoWinningStatics.NumberOfMatches.FIVE_MATCHES
            matchNumber==4->LottoWinningStatics.NumberOfMatches.FOUR_MATCHES
            matchNumber==3->LottoWinningStatics.NumberOfMatches.THREE_MATCHES
            else->LottoWinningStatics.NumberOfMatches.RESULT_RATE
        }
    }
}