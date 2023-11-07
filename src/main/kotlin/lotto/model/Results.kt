package lotto.model

import lotto.util.Match

class Results(
    var _result: MutableMap<Int, Int> = mutableMapOf(
        Match.THIRD.count to FOR_INIT_ZERO_NUMBER,
        Match.FOURTH.count to FOR_INIT_ZERO_NUMBER,
        Match.FIFTH.count to FOR_INIT_ZERO_NUMBER,
        Match.FIFTH_BONUS.count to FOR_INIT_ZERO_NUMBER,
        Match.SIX.count to FOR_INIT_ZERO_NUMBER,
    )
) {
    val result get() = _result.toMap()

    fun update(data: Pair<Int, Int>) {
        if (data.first !in 3..6) {
            return
        }

        var key = data.first
        if (data.first == 5) {
            key = Match.FIFTH.count.takeIf { data.second == 0 } ?: Match.FIFTH_BONUS.count
        }

        _result[key] = _result.getOrDefault(key, 0) + 1
    }

    companion object {
        private const val FOR_INIT_ZERO_NUMBER = 0
    }
}