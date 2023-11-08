package lotto

class Utils {
    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_NUMBER_SIZE = 6

        const val GET_SEED_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        const val NUMBER_OF_TICKETS_MESSAGE = "개를 구매했습니다."
        const val GET_REAL_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val GET_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

        const val RESULT_MESAGE = "당첨 통계\n" + "---"
        const val FIFTH_PLACE = "3개 일치 (5,000원) - "
        const val FOURTH_PLACE = "4개 일치 (50,000원) - "
        const val THIRD_PLACE = "5개 일치 (1,500,000원) - "
        const val SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val FIRST_PLACE = "6개 일치 (2,000,000,000원) - "
        const val PLACE_END_MESSAGE = "개"
        const val ROI_PERCENTAGE = "총 수익률은 "
        const val ROI_END_MESSAGE = "입니다."
    }
}