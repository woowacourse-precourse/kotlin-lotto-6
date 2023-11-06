package lotto.data

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LENGTH_OF_NUM) {
            LENGTH_IS_NOT_CORRECT
        }
        require(numbers.toSet().size == LENGTH_OF_NUM) {
            DUPLICATE_IS_NOT_ALLOWED
        }
        require(numbers.sorted() == numbers) {
            NUMBER_SHOULD_BE_ORDERED
        }
    }

    fun checkGrade(win: Lotto, bonusNum: Int): GRADE {
        val countOfSame = numbers.intersect(win.numbers.toSet()).size
        val isBonusContain = countOfSame == 5 && bonusNum in numbers
        return GRADE.from(countOfSame, isBonusContain)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LENGTH_OF_NUM = 6
        const val START_NUM = 1
        const val END_NUM = 45
        private const val LENGTH_IS_NOT_CORRECT = "[ERROR] 여섯 개의 숫자를 입력하세요."
        private const val DUPLICATE_IS_NOT_ALLOWED = "[ERROR] 번호는 중복될 수 없습니다."
        private const val NUMBER_SHOULD_BE_ORDERED = "[ERROR] 오름차순으로 정렬해서 입력하세요."
    }
}
