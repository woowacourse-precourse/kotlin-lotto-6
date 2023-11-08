package lotto

import lotto.utils.Strings

enum class LottoRank(val matchCount: Int, val prize: Int) {

    NONE(0, Strings.LOTTO_RANK_NONE),
    FIFTH(3, Strings.LOTTO_RANK_FIFTH),
    FOURTH(4, Strings.LOTTO_RANK_FOURTH),
    THIRD(5, Strings.LOTTO_RANK_THIRD),
    SECOND(5, Strings.LOTTO_RANK_SECOND),
    FIRST(6, Strings.LOTTO_RANK_FIRST);


    companion object {
        fun fromMatchCount(matchCount: Int): LottoRank {
            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}

