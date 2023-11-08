package lotto.data

object ConstNum {

    const val THREE_LOTTO_AMOUNT = 5000
    const val FOUR_LOTTO_AMOUNT= 50000
    const val FIVE_LOTTO_AMOUNT = 1500000
    const val FIVE_BONUS_LOTTO_AMOUNT = 30000000
    const val SIX_LOTTO_AMOUNT = 2000000000


}
object ConstString {
    const val THREE_CORRESPONDING = "3개 일치"
    const val FOUR_CORRESPONDING= "4개 일치"
    const val FIVE_CORRESPONDING = "5개 일치"
    const val FIVE_BONUS_CORRESPONDING ="5개 일치, 보너스 볼 일치"
    const val SIX_CORRESPONDING = "6개 일치"

    const val THREE_LOTTO_AMOUNT = "5,000"
    const val FOUR_LOTTO_AMOUNT= "50,000"
    const val FIVE_LOTTO_AMOUNT = "1,500,000"
    const val FIVE_BONUS_LOTTO_AMOUNT = "30,000,000"
    const val SIX_LOTTO_AMOUNT = "2,000,000,000"

    const val INPUT_LOTTO_AMOUNT = "구입금액을 입력해주세요"
    const val INPUT_LOTTO_NUM = "당첨번호를 입력해주세요"
    const val INPUT_BONUS_NUM = "보너스 번호를 입력해주세요"
    const val LOTTO_STATISTICS ="당첨 통계"
    const val REVENUE_MESSAGE = "총 수익률은 %s%%입니다."
    const val LOTTO_COUNTS_MESSAGE = "%s개를 구매했습니다."


}

object ErrorMessage {
    const val ERROR_LOTTO_AMOUNTS= "[ERROR] 로또 번호는 1000원 단위의 금액이어야 합니다."
    const val ERROR_LOTTO_NUM = "[ERROR] 로또 번호는 1부터 45 사이의 6가지 숫자여야 합니다."
    const val ERROR_LOTTO_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다."

}