package lotto

class LottoView {
    fun purchaseView(){
        println("구입금액을 입력해주세요.")
    }
    fun buyView(cnt: Int){
        println(cnt.toString() + "개를 구매했습니다.")
    }
    fun numbersList(numbers: List<Int>){
        println(numbers)
    }

    fun pickView(){
        println("당첨 번호를 입력해주세요.")
    }

    fun bonusView(){
        println("보너스 번호를 입력해주세요.")
    }
}