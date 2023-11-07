package lotto.exception

import lotto.util.Constants

class IllegalBonusNumberException : IllegalArgumentException() {
    override val message: String
        get() = "${Constants.ERROR} 올바른 숫자를 입력해주세요."
}
