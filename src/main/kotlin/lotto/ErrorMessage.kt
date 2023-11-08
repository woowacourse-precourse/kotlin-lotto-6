package lotto

object ErrorMessage {
    const val INVALID_LOTTO_RANGE = "로또 번호는 ${Constants.MIN_LOTTO_NUMBER}부터 ${Constants.MAX_LOTTO_NUMBER} 사이의 숫자여야 합니다."
    const val BONUS_NUMBER_INTERSECTED = "보너스 번호가 당첨 번호와 겹쳤습니다."
    const val WINNING_NUMBER_INTERSECTED = "당첨 번호가 중복됐습니다."
    const val BUDGET_NOT_DIVIDED = "로또 구입 금액은 로또 가격으로 나누어 떨어져야 합니다. 로또 가격은 ${Constants.PRICE_OF_LOTTO}원 입니다."
    const val BUDGET_UNDER_ZERO = "로또 구입 금액은 음수면 안됩니다."
    const val EMPTY_INPUT = "입력된 것이 없습니다. 공백문자는 무시됩니다."
    const val LACK_OF_NUMBER = "당첨 번호 수가 모자랍니다. ${Constants.LOTTO_COUNT}개를 입력해야 합니다."
    const val INVALID_NUMBER = "입력은 숫자여야 합니다."
    fun print(message: String) {
        println("[ERROR] $message")
    }
}
