package lotto

class ExceptionManager {

    fun moneyException(num: String) {
        val money = num.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
        if (money < 1) {
            throw IllegalArgumentException("1 이상의 금액을 입력해주세요")
        }
        if (money % 1000 != 0) {
            throw IllegalArgumentException("1,000원 단위 금액을 입력해주세요")
        }
        if (money > 100000) {
            throw IllegalArgumentException("구입 최대 금액은 10만원입니다.")
        }
    }
}