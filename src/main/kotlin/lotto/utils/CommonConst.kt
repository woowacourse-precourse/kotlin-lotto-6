package lotto.utils

object CommonConst {

    // inputs
    const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val MESSAGE_INPUT_WINNING_NUMBERS= "당첨 번호를 입력해 주세요."
    const val MESSAGE_INPUT_BONUS_NUMBER= "보너스 번호를 입력해 주세요."

    // outputs
    const val MESSAGE_WINNING_STATISTICS= "당첨 통계\n---"
    //formatter 사용 예정 : MESSAGE_NUMBER_of_PURCHASES.format(상수값)
    const val MESSAGE_NUMBER_of_PURCHASES = "%d개를 구매했습니다."
    const val MESSAGE_LOTTO_WINNING_DETAILS_3_MATCHES = "3개 일치 (5,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_4_MATCHES = "4개 일치 (50,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES = "5개 일치 (1,500,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_6_MATCHES = "6개 일치 (2,000,000,000원) - %d개"
    const val MESSAGE_TOTAL_RETURN = "총 수익률은 %d%입니다."

    //exceptions
    const val ILLEGAL_ARGUMENT_EXCEPTION_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
}


