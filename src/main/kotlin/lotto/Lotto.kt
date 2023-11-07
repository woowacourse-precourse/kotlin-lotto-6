package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] 로또 번호는 6자리 이어야 합니다."
        }
        require(validate()) {
            "[ERROR] 로또 번호는 중복이 있을 수 없습니다."
        }
    }

    // TODO: 추가 기능 구현

    fun confirmLottoResult(winLotto: List<Int>, bonusNumber: Int): String {
        var target = 0
        var win = 0
        var matchCount = 0

        while (target < LOTTO_LENGTH && win < LOTTO_LENGTH) {
            if (numbers[target] == winLotto[win]) {
                target++
                win++
                matchCount++
                continue
            }

            if (numbers[target] < winLotto[win]) {
                target++
                continue
            }
            if (numbers[target] > winLotto[win]) {
                win++
                continue
            }
        }

        if (matchCount == 5 && numbers.contains(bonusNumber)) return SECOND_RANK

        return when (matchCount) {
            6 -> FIRST_RANK
            5 -> THIRD_RANK
            4 -> FOURTH_RANK
            3 -> FIFTH_RANK
            else -> NO_RANK
        }
    }

    private fun validate(): Boolean {
        val setResult = mutableSetOf<Int>()
        numbers.forEach { number -> setResult.add(number) }
        return numbers.size == setResult.size
    }

    companion object {
        const val LOTTO_LENGTH = 6

        // 이렇게 하는게 맞을까?
        const val FIRST_RANK = "FIRST"
        const val SECOND_RANK = "SECOND"
        const val THIRD_RANK = "THIRD"
        const val FOURTH_RANK = "FOURTH"
        const val FIFTH_RANK = "FIFTH"
        const val NO_RANK = "LOSE"
    }
}
