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
        for(indexing in 5 downTo 1){
            val result = getWinningPrice(indexing).correspondResult
            val price = getWinningPrice(indexing).price

            val formattedPrice = String.format("%,d원", price)
            println("$result ($formattedPrice) - ${winningList[indexing]}개")}
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