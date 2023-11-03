package lotto.view

private const val PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요."
private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
class OutputView {
    fun printPurchaseAmount(){
        println(PURCHASE_AMOUNT_MSG)
    }
    fun printLottoCount(lottoCount:Int){
        println(LOTTO_COUNT_MSG.format(lottoCount))
    }
}