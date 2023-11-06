package lotto

object Constants {
    const val PRICE = 1000
    const val START = 1
    const val END = 45
    const val COUNT = 6
    const val FIRST_PLACE = 5
    const val SECOND_PLACE = 4
    const val THIRD_PLACE = 3
    const val FOURTH_PLACE = 2
    const val FIFTH_PLACE = 1
    const val NOTHING = 0

    const val ASK_AMOUNT = "구입금액을 입력해 주세요."
    const val AMOUNT_ERROR = "[ERROR] 1000원 단위의 숫자를 입력하세요.\n"
    const val PURCHASED = "개를 구매했습니다."
    const val ASK_WIN_NUM = "당첨 번호를 입력해 주세요."
    const val WIN_NUM_ERROR = "[ERROR] 1~45 범위의 숫자를 6개 입력해 주세요."
    const val ASK_BONUS_NUM = "보너스 번호를 입력해 주세요."
    const val BONUS_ERROR = "[ERROR] 당첨 번호를 제외한 1~45 범위의 숫자를 1개 입력해 주세요."
    const val COUNT_ERROR = "로또 번호는 6개여야 합니다."
    const val DUPLICATE_ERROR = "중복된 번호 입니다."
}