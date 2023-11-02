package lottoView

import lottoViewModel.ValidInput

class LottoOutPut {
   enum class LottoMent(val message:String){
       INPUT_PURCHASE("구입금액을 입력해 주세요."),
       PURCHASE_DETAIL("개를 구매했습니다.")
   }

    init{
        println(LottoMent.INPUT_PURCHASE.message)
    }
    fun purchaseDetailPrint(purchaseAmount:Int) {
     println("$purchaseAmount"+LottoMent.PURCHASE_DETAIL.message)
    }
}