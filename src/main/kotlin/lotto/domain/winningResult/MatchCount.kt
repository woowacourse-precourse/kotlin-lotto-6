package lotto.domain.winningResult

import lotto.exception.MatchCountException

class MatchCount(var count: Int) {
    init {
        require(count >= 0) { MatchCountException.NOT_POSITIVE_NUMBER.message }
    }

    override fun toString(): String = "%d$UNIT_SUFFIX".format(count)

    companion object {
        private const val UNIT_SUFFIX = "개"
    }
}