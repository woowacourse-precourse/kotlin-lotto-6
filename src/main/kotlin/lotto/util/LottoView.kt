package lotto.util

class LottoView {
    fun purchaseView() {
        println("구입금액을 입력해주세요.")
    }
    fun buyView(cnt: Int) {
        println("\n${cnt}개를 구매했습니다.")
    }
    fun numbersList(numbers: List<Int>) {
        println(numbers)
    }

    fun pickView() {
        println("\n당첨 번호를 입력해주세요.")
    }

    fun bonusView() {
        println("\n보너스 번호를 입력해주세요.")
    }

    fun prizeStatusView(lottoResult: List<Int>) {
        println("\n당첨 통계 \n---")
        println("3개 일치 (5,000원) - ${lottoResult[4]}개")
        println("4개 일치 (50,000원) - ${lottoResult[3]}개")
        println("5개 일치 (1,500,000원) - ${lottoResult[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResult[1]}개")
        println("6개 일치 (2,000,000,000원) - ${lottoResult[0]}개")
    }
    fun totalRate(rate: String) {
        println("총 수익률은 ${rate}%입니다.")
    }
}