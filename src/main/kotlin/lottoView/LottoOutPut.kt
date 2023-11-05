package lottoView

import lotto.main
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput

class LottoOutPut {
    private val createNumbers=CreateNumbers()
   enum class LottoMent(val message:String){
       INPUT_PURCHASE("구입금액을 입력해 주세요."),
       PURCHASE_DETAIL("개를 구매했습니다."),
       WINNING_NUMBER("당첨 번호를 입력해 주세요."),
       BONUS_NUMBER("보너스 번호를 입력해주세요."),
   }
    fun startMent()=println(LottoMent.INPUT_PURCHASE.message)
    fun purchaseDetailPrint(purchaseAmount:Int) {
     println("$purchaseAmount"+LottoMent.PURCHASE_DETAIL.message)
    }
    fun randomNumbersPrint(purchaseAmount: Int){
        for(time in 0 until purchaseAmount){
            val numbers=createNumbers.createRandomNumbers()
            println(numbers)
        }
    }
    fun printlnWiningNumberMent(){
        println(LottoMent.WINNING_NUMBER.message)
    }
    fun printlnWinningNumber(){
      println(ValidInput().validWinningNumbers(ValidInput().convertWinningNumbers()))
    }
    fun printlnBonusNumberMent(){
        println(LottoMent.BONUS_NUMBER.message)
    }
}