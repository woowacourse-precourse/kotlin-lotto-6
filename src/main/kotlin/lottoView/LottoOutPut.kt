package lottoView

import lotto.Lotto
import lottoViewModel.ValidInput
class LottoOutPut {
    enum class LottoMent(val message:String){
       INPUT_PURCHASE("구입금액을 입력해 주세요."),
       PURCHASE_DETAIL("개를 구매했습니다."),
       WINNING_NUMBER("당첨 번호를 입력해 주세요."),
       BONUS_NUMBER("보너스 번호를 입력해주세요."),
        WINNING_STATISTICS("당첨 통계"),
        THREE_BAR("---")
   }
    fun startMent()=println(LottoMent.INPUT_PURCHASE.message)
    fun purchaseDetailPrint(purchaseAmount:Int) {
     println("$purchaseAmount"+LottoMent.PURCHASE_DETAIL.message)
    }
    fun printLottoList(purchaseAmount:Int,lottoList:List<Lotto>){
        for(indexing in 0 until purchaseAmount){
            println(lottoList[indexing].getLottoNumberString())
        }
    }
     fun printlnWiningNumberMent(){
        println(LottoMent.WINNING_NUMBER.message)
    }
    fun printlnBonusNumberMent(){
        println(LottoMent.BONUS_NUMBER.message)
    }
    private fun printlnOutPutMent(){
        println(LottoMent.WINNING_STATISTICS.message)
    }
    private fun printlnThreeBar(){
        println(LottoMent.THREE_BAR.message)
    }
    fun outputMent(){
        printlnOutPutMent()
        printlnThreeBar()
    }
    fun printWinningResult(winningList : Map<Int, Int>) {
        for(i in 5 downTo 1){
            val result = getWinningPrice(i).correspondResult
            val price = getWinningPrice(i).price

            val formattedPrice = String.format("%,d원", price)
            println("$result ($formattedPrice) - ${winningList[i]}개")}
    }

    private fun getWinningPrice(rank: Int): ValidInput.WinningPrice {
        return when (rank) {
            5 -> ValidInput.WinningPrice.THREE
            4 -> ValidInput.WinningPrice.FOUR
            3 -> ValidInput.WinningPrice.FIVE
            2 -> ValidInput.WinningPrice.FIVEANDBONUS
            1 -> ValidInput.WinningPrice.SIX
            else -> ValidInput.WinningPrice.ZERO
        }
    }
}