package exception


class Exception {
    companion object {
        const val EXCEPTION_INVALID_SIZE = "[ERROR] 로또 번호는 6개만 가능합니다."
        const val EXCEPTION_INVALID_NUMBER = "[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다."
        const val EXCEPTION_INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다."
        const val EXCEPTION_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다."
        const val EXCEPTION_INVALID_TYPE = "[ERROR] 로또 번호는 숫자만 가능합니다."
        const val EXCEPTION_INVALID_MONEY = "[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다."
        const val EXCEPTION_INVALID_MONEY_TYPE = "[ERROR] 로또 구입 금액은 숫자만 가능합니다."
        const val EXCEPTION_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."
    }
}