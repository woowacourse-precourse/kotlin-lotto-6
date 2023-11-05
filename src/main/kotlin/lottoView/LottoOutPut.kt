package lottoView

import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput

class LottoOutPut {

    enum class LottoMent(val message:String){
       INPUT_PURCHASE("구입금액을 입력해 주세요."),
       PURCHASE_DETAIL("개를 구매했습니다."),
       WINNING_NUMBER("당첨 번호를 입력해 주세요."),
       BONUS_NUMBER("보너스 번호를 입력해주세요."),
        WINNING_STATISTICS("당첨 통계")
   }
    fun startMent()=println(LottoMent.INPUT_PURCHASE.message)
    fun purchaseDetailPrint(purchaseAmount:Int) {
     println("$purchaseAmount"+LottoMent.PURCHASE_DETAIL.message)
    }
    fun randomNumbersPrint(purchaseAmount: Int){

        val createNumbers=CreateNumbers()
        for(time in 0 until purchaseAmount){
            val numbers=createNumbers.createRandomNumbers()
            println(numbers)
        }
    }
    fun printlnWiningNumberMent(){
        println(LottoMent.WINNING_NUMBER.message)
    }
    fun printlnWinningNumber(){
        val winningNumber=ValidInput().validWinningNumbers(ValidInput().convertWinningNumbers())
      println(winningNumber.joinToString(","))
    }
    fun printlnBonusNumberMent(){
        println(LottoMent.BONUS_NUMBER.message)
    }
    fun printlnOutPutMent(){
        println(LottoMent.WINNING_STATISTICS.message)
    }
}