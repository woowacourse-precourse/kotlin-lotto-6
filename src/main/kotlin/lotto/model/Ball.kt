package lotto.model

import lotto.isInRange
import lotto.requireAndReturn
import lotto.toValidInt

@JvmInline
value class Ball(val number: Int) {

    constructor(value: String) : this(value.toValidInt())

    init {
        number.validIsInRange()
    }

    private fun Int.validIsInRange(): Int =
        requireAndReturn(this.isInRange(MIN_NUMBER, MAX_NUMBER), OUT_OF_RANGE_ERROR)

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        internal const val OUT_OF_RANGE_ERROR = "$MIN_NUMBER~${MAX_NUMBER}의 값만 입력할 수 있습니다."
    }
}

fun List<Int>.toBalls(): List<Ball> = this.sorted().map { Ball(it) }