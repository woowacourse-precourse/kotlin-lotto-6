package lotto.domain.util

class Validator {
    fun amount(amount: String): Int {
        require(isNotEmpty(amount)) { NOT_EMPTY }
        require(isNotBlank(amount)) { NOT_BLANK }
        requireNotNull(isNumber(amount)) { ONLY_INT }
        require(isPositiveNumber(amount)) { ONLY_POSITIVE_INT }
        require(isDivisibleByThousand(amount)) { MUST_DIVISIBLE_BY_1000 }
        return amount.toInt()
    }

    fun drawNumber(drawNumber: String): List<Int> {
        require(isNotEmpty(drawNumber)) { NOT_EMPTY }
        require(isNotBlank(drawNumber)) { NOT_BLANK }
        val split = drawNumber.split(SEPARATOR)
        require(hasSixValue(split)) { MUST_SIX_VALUE }
        require(hasSixNumber(split)) { MUST_SIX_NUMBER }
        require(isDrawNumber(split)) { MUST_1_TO_45 }
        require(isDuplicate(split)) { NOT_DUPLICATE }
        return split.map { it.toInt() }
    }

    fun bonusNumber(bonusNumber: String, drawNumbers: List<Int>): Int {
        require(isNotEmpty(bonusNumber)) { NOT_EMPTY }
        require(isNotBlank(bonusNumber)) { NOT_BLANK }
        requireNotNull(isNumber(bonusNumber)) { BONUS_ONLY_INT }
        require(isBonusNumber(bonusNumber)) { BONUS_MUST_1_TO_45 }
        require(!isBonusDuplicate(bonusNumber, drawNumbers)) {
            BONUS_NOT_DUPLICATE_DRAW.format(
                drawNumbers.joinToString(
                    SEPARATOR
                )
            )
        }
        return bonusNumber.toInt()
    }

    companion object {
        // 사용자를 혼내는 게 아니다. 에러 메시지를 보고 제대로 입력할 수 있도록 유도해야 한다.
        const val NOT_EMPTY = "아무것도 입력하지 않았어요."
        const val NOT_BLANK = "공    백만 있어요."
        const val START_NUMBER = 1
        const val END_NUMBER = 45

        // amount
        const val ONLY_INT = "숫자만 입력해 주세요. 입력 예시 -> 8000 (설마 21억 4748만 3647원보다 많이 사려는 부자는 아니겠죠?)"
        const val ONLY_POSITIVE_INT = "제 돈을 뺏어갈 속셈인가요..? 입력 예시 -> 8000"
        const val MUST_DIVISIBLE_BY_1000 = "동전은 필요 없어요. 지폐만 주세요. 입력 예시 -> 8000"
        const val ZERO = 0
        const val THOUSAND = 1000

        // drawNumber
        const val MUST_SIX_VALUE = "6개의 숫자를 입력해주세요. 입력 예시 -> 1,6,11,23,37,45"
        const val MUST_SIX_NUMBER = "입력값중 숫자가 아닌게 있어요. 입력 예시 -> 1,6,11,23,37,45"
        const val MUST_1_TO_45 = "1~45사이의 숫자가 아닌게 있어요. 입력 예시 -> 1,6,11,23,37,45"
        const val NOT_DUPLICATE = "중복된 숫자가 있어요"
        const val SIX = 6
        const val SEPARATOR = ","

        // bonusNumber
        const val BONUS_ONLY_INT = "하나의 숫자만 입력해주세요. 입력 예시 -> 16"
        const val BONUS_MUST_1_TO_45 = "1~45사이의 숫자가 아닌게 있어요. 입력 예시 -> 16"
        const val BONUS_NOT_DUPLICATE_DRAW = "당첨 번호 %s와 중복된 숫자가 있어요"

        fun isNotEmpty(input: String): Boolean = input.isNotEmpty()

        fun isNotBlank(input: String): Boolean = input.isNotBlank()

        fun isNumber(input: String): Int? = input.toIntOrNull()

        fun isPositiveNumber(input: String): Boolean =
            input.toInt() > ZERO

        fun isDivisibleByThousand(input: String): Boolean =
            input.toInt().rem(THOUSAND) == ZERO

        fun hasSixValue(input: List<String>): Boolean =
            input.size == SIX

        fun hasSixNumber(input: List<String>): Boolean =
            input.map { it.toIntOrNull() }.all { it != null }

        fun isDrawNumber(input: List<String>): Boolean =
            input.map { it.toInt() }.all { it in START_NUMBER..END_NUMBER }

        fun isDuplicate(input: List<String>): Boolean =
            input.toSet().size == SIX

        fun isBonusNumber(input: String): Boolean =
            input.toInt() in START_NUMBER..END_NUMBER

        fun isBonusDuplicate(input: String, drawNumbers: List<Int>): Boolean =
            drawNumbers.contains(input.toInt())
    }
}