package lotto.Constants

object LottoException {
    const val BUY_LOTTO_PRICE_1000 = "[ERROR] 구입 금액은 1000원 단위여야 합니다."
    const val BUY_LOTTO_PRICE_INVALIDATE_NUMBER = "[ERROR] 유효하지 않은 입력입니다. 구입 금액을 숫자로 입력해 주세요."
    const val INPUT_NULL = "[ERROR] 입력이 null입니다."
    const val INPUT_LOTTO_1TO45 = "[ERROR] 1부터 45 사이의 숫자여야 합니다."
    const val INPUT_LOTTO_INVALID_TYPE = "[ERROR] 숫자가 아닌 값이 포함되어 있습니다."
}

object InputLottoNumsException {
    const val INPUT_LOTTO_6NUMBERS = "[ERROR] 6개의 숫자를 입력해야 합니다."
    const val INPUT_LOTTO_ISDUPLICATED = "[ERROR] 중복되지 않은 6개의 숫자를 입력해야 합니다."
}

object InputBonusNumException {
    const val INPUT_BONUS_ISDUPLICATED = "[ERROR] 입력한 로또 번호와 달라야 합니다."
}