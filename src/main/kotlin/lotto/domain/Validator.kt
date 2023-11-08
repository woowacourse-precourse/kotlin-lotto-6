package lotto.domain

import lotto.data.Lotto

class Validator private constructor() {

    fun checkInputIsPositiveNum(input: String): Boolean {
        val number = input.toUIntOrNull()
        return number != null && number > UNSIGNED_ZERO
    }

    fun checkInputIsConsistOfPositiveNum(input: String): Boolean {
        return input.split(IO.INPUT_SPLITTER).all {
            checkInputIsPositiveNum(it)
        }
    }

    fun checkLottoNumberIsCorrect(numbers: List<Int>) {
        require(numbers.all { it in Lotto.START_NUM..Lotto.END_NUM }) {
            NUMBER_IS_NOT_IN_LOTTO_RANGE
        }
        require(numbers.size == Lotto.LENGTH_OF_NUM) {
            LENGTH_IS_NOT_CORRECT
        }
        require(numbers.toSet().size == Lotto.LENGTH_OF_NUM) {
            DUPLICATE_IS_NOT_ALLOWED
        }
        require(numbers.sorted() == numbers) {
            NUMBER_SHOULD_BE_ORDERED
        }
    }

    fun checkInputOfBonusCorrect(input: String, lottoNums: List<Int>) {
        val bonus = input.toIntOrNull()
        require(bonus in Lotto.START_NUM..Lotto.END_NUM) {
            NUMBER_IS_NOT_IN_LOTTO_RANGE
        }
        checkLottoNumberIsCorrect(lottoNums)
        require(lottoNums.contains(bonus).not()) {
            BONUS_SHOULD_NOT_BE_DUPLICATE
        }
    }

    fun checkInputOfBonusCorrect(bonus: Int, lottoNums: List<Int>) {
        require(bonus in Lotto.START_NUM..Lotto.END_NUM) {
            NUMBER_IS_NOT_IN_LOTTO_RANGE
        }
        checkLottoNumberIsCorrect(lottoNums)
        require(lottoNums.contains(bonus).not()) {
            BONUS_SHOULD_NOT_BE_DUPLICATE
        }
    }

    companion object {
        const val DUPLICATE_IS_NOT_ALLOWED = "[ERROR] 번호는 중복될 수 없습니다."
        const val NUMBER_SHOULD_BE_ORDERED = "[ERROR] 오름차순으로 정렬해서 입력하세요."
        const val LENGTH_IS_NOT_CORRECT = "[ERROR] 여섯 개의 숫자를 입력하세요."
        const val BONUS_SHOULD_NOT_BE_DUPLICATE = "[ERROR] 보너스 번호는 기본 번호와 중복될 수 없습니다."
        const val NUMBER_IS_NOT_IN_LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val UNSIGNED_ZERO = 0u

        private var instance: Validator? = null

        fun getInstance(): Validator {
            val currentInstance = instance
            if (currentInstance != null) {
                return currentInstance
            }
            return synchronized(this) {
                val synchronizedInstance = instance
                if (synchronizedInstance != null) {
                    return@synchronized synchronizedInstance
                }
                val createdValidator = Validator()
                instance = createdValidator
                createdValidator
            }
        }

        fun releaseInstance() {
            instance = null
        }
    }
}