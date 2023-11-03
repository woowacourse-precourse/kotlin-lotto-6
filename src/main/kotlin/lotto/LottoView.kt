package lotto

class LottoView {
    fun purchaseView(){
        println("구입금액을 입력해주세요.")
    }
    fun buyView(cnt: Int){
        println(cnt.toString() + "개를 구매했습니다.")
    }
}