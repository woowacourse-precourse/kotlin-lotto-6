package lotto.utils

object CommonConst {

    // inputs
    const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val MESSAGE_INPUT_WINNING_NUMBERS= "당첨 번호를 입력해 주세요."
    const val MESSAGE_INPUT_BONUS_NUMBER= "보너스 번호를 입력해 주세요."

    // outputs
    const val MESSAGE_WINNING_STATISTICS= "당첨 통계\n---"
    //formatter 사용 예정 : MESSAGE_NUMBER_of_PURCHASES.format(상수값)
    const val MESSAGE_NUMBER_OF_PURCHASES = "%d개를 구매했습니다."
    const val MESSAGE_LOTTO_WINNING_DETAILS_3_MATCHES = "3개 일치 (5,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_4_MATCHES = "4개 일치 (50,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES = "5개 일치 (1,500,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    const val MESSAGE_LOTTO_WINNING_DETAILS_6_MATCHES = "6개 일치 (2,000,000,000원) - %d개"
    const val MESSAGE_TOTAL_PRIZE_RATE = "총 수익률은 %.1f"
    const val MESSAGE_TOTAL_PRIZE_RATE_THE_REST = "%입니다."
    
    // generateLottoNumbers()
    const val GENERATE_LOTTO_NUMBERS_MIN = 1
    const val GENERATE_LOTTO_NUMBERS_MAX = 45
    const val GENERATE_LOTTO_NUMBERS_COUNT = 6

    // prize
    const val FIRST_PRIZE = 2000000000
    const val SECOND_PRIZE = 30000000
    const val THIRD_PRIZE = 1500000
    const val FOURTH_PRIZE = 50000
    const val FIFTH_PRIZE = 5000

    // exceptions
    // purchase
    const val ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE_IS_NOT_DIGIT = "[ERROR] 숫자가 아닌 값을 입력하셨습니다. 다시 입력해주세요."
    const val ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE = "[ERROR] 유효하지 않은 금액입니다. 1,000원 단위로 입력해주세요."
    // winning numbers
    const val ILLEGAL_ARGUMENT_EXCEPTION_WINNING_NUMBERS_IS_NOT_DIGIT = "[ERROR] 숫자가 아닌 값을 입력하셨습니다. 다시 입력해주세요."
    const val ILLEGAL_ARGUMENT_EXCEPTION_WINNING_NUMBERS = "[ERROR] 유효하지 않은 번호입니다. 6자리의 서로다른 번호를 입력해주세요"
    // bonus number
    const val ILLEGAL_ARGUMENT_EXCEPTION_BONUS_NUMBER_CONTAIN_WINNING_NUMBER = "[ERROR] 보너스 숫자는 추첨 번호와 다른 값을 입력해주세요."
    const val ILLEGAL_ARGUMENT_EXCEPTION_BONUS_NUMBER_IS_NOT_DIGIT = "[ERROR] 숫자가 아닌 값을 입력하셨습니다. 다시 입력해주세요."
    const val ILLEGAL_ARGUMENT_EXCEPTION_BONUS_NUMBER = "[ERROR] 유효하지 않은 번호입니다. 1자리의 정수를 입력해주세요"

    const val ILLEGAL_ARGUMENT_EXCEPTION_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
}


