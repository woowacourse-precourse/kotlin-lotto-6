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

    fun winningNumberException(nums: List<String>) {
        val numbers = mutableListOf<Int>()

        for (num in nums) {
            val convertedNum = num.toIntOrNull()
            convertedNum?.let {
                numbers.add(convertedNum)
            } ?: throw IllegalArgumentException("문자가 아닌 숫자를 입력해주세요.")
        }

        for (index in numbers) {
            if (index > 45 || index < 1) {
                throw IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.")
            }
        }
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException("동일한 번호가 중복되었습니다.")
        }
        if (numbers.distinct().size != 6 ) {
            throw IllegalArgumentException("6개의 당첨번호를 입력해주세요.")
        }
    }
}