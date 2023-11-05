package lotto.domain.util

class Validator {
    fun validateAmount(amount: String): Int {
        require(isNotEmpty(amount)) { NOT_EMPTY }
        require(isNotBlank(amount)) { NOT_BLANK }
        requireNotNull(isNumber(amount)) { ONLY_INT }
        require(isPositiveNumber(amount)) { ONLY_POSITIVE_INT }
        require(isDivisibleByThousand(amount)) { MUST_DIVISIBLE_BY_1000 }
        return amount.toInt()
    }

    companion object {
        // 사용자를 혼내는 게 아니다. 에러 메시지를 보고 제대로 입력할 수 있도록 유도해야 한다.
        const val NOT_EMPTY = "아무것도 입력하지 않았어요."
        const val NOT_BLANK = "공    백    만    있    어    요."
        const val ONLY_INT = "숫자만 입력해 주세요. (설마 21억 4748만 3647원보다 많이 사려는 부자는 아니겠죠?)"
        const val ONLY_POSITIVE_INT = "제 돈을 뺏어갈 속셈인가요..?"
        const val MUST_DIVISIBLE_BY_1000 = "동전은 필요 없어요. 지폐만 주세요."

        private const val ZERO = 0
        private const val THOUSAND = 1000

        fun isNotEmpty(input: String): Boolean {
            return input.isNotEmpty()
        }

        fun isNotBlank(input: String): Boolean {
            return input.isNotBlank()
        }

        fun isNumber(input: String): Int? {
            return input.toIntOrNull()
        }

        fun isPositiveNumber(input: String): Boolean {
            return input.toInt() > ZERO
        }

        fun isDivisibleByThousand(input: String): Boolean {
            return input.toInt().rem(THOUSAND) == ZERO
        }
    }
}