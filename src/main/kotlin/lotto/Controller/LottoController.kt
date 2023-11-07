package lotto.Controller

import lotto.LottoGameModel

fun howManyBuyLotto(lottoPrice: String): Int {
    try {
        val price = lottoPrice.toInt()

        if (price % 1000 == 0) {
            return price / 1000
        } else {
            // 1000으로 나누어 떨어지지 않는 경우 예외 던지기
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
        }
    } catch (e: NumberFormatException) {
        // 문자열을 정수로 변환할 수 없는 경우 예외 던지기
        throw IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 구입 금액을 숫자로 입력해 주세요.")
    }
}

object LottoController {
    fun gameStart() {
        println("구입금액을 입력해 주세요.")
        val lottoPrice = readLine()
        var lottoGameModel: LottoGameModel? = null

        if (lottoPrice != null) {
            try {
                val numberOfLottoTickets = howManyBuyLotto(lottoPrice)
                println("\n$numberOfLottoTickets 개를 구매했습니다.")
                lottoGameModel = LottoGameModel(numberOfLottoTickets)
//                println(lottoGameModel.lottoList)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }

        // lottoGameModel가 null이 아닌 경우에만 사용
        lottoGameModel?.run {
            // LottoGameModel에 대한 작업 수행
            lottoGameModel.printLottoNumbers()
        }
    }
}
