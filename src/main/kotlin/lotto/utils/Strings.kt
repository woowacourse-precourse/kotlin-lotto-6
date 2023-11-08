package lotto.utils

object Strings {
    const val EXCEPTION_COMMON = "[ERROR] 올바른 값을 입력해 주세요."
    const val EXCEPTION_PURCHASE_AMOUNT = "[ERROR] 구입 금액을 1,000원 단위로 입력해 주세요."
    const val EXCEPTION_WINNING_NUMBER = "[ERROR] 올바른 당첨 번호를 입력해주세요."
    const val EXCEPTION_NUMBER = "[ERROR] 숫자를 입력해주세요."
    const val EXCEPTION_OVERLAP = "[ERROR] 당첨 번호와 중복되지 않게 입력해주세요."

    const val LOTTO_EXCEPTION_LIMIT = "[ERROR] 로또 번호는 6개여야 합니다."
    const val LOTTO_EXCEPTION_OVERLAP = "[ERROR] 로또 번호에 중복된 숫자가 있습니다."
    const val LOTTO_EXCEPTION_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."

    const val VIEW_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요."
    const val VIEW_PURCHASE = "개를 구매했습니다."
    const val VIEW_WINNING_NUMBER = "당첨 번호를 입력해 주세요. (1~45까지의 숫자 6개, 쉼표로 구분)"
    const val VIEW_BONUS_NUMBER = "보너스 번호를 입력해 주세요. (1~45까지의 숫자)"
    const val VIEW_WINNING_STATISTICS = "당첨 통계"

    const val CONTROLLER_TOTAL = "총 수익률은 "
    const val CONTROLLER_PERCENT = "%입니다."

    const val LOTTO_RANK_NONE = 0
    const val LOTTO_RANK_FIFTH = 5_000
    const val LOTTO_RANK_FOURTH = 50_000
    const val LOTTO_RANK_THIRD = 1_500_000
    const val LOTTO_RANK_SECOND = 30_000_000
    const val LOTTO_RANK_FIRST = 2_000_000_000
}