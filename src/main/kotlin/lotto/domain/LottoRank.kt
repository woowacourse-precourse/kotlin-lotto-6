package lotto.domain

class LottoRank(private val matchCount: Int, private val bonus: Boolean, val prize: Int) {

    companion object {
        fun getRank(matchCount: Int, matchBonus: Boolean) {
        }
    }
}
