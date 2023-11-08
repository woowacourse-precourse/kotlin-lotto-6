package lotto

enum class LottoRank(val prize: Long) {
    FIRST(LottoConstraints.FIRST_PRIZE),
    SECOND(LottoConstraints.SECOND_PRIZE),
    THIRD(LottoConstraints.THIRD_PRIZE),
    FOURTH(LottoConstraints.FOURTH_PRIZE),
    FIFTH(LottoConstraints.FIFTH_PRIZE),
    NONE(LottoConstraints.NO_PRIZE);
}

fun normalNumberMatch(lottoNumber: Lotto, normalNumbers: List<Int>): Int {
    return lottoNumber.count { it in normalNumbers }
}

fun bonusNumberMatch(lottoNumber: Lotto, bonusNumber: Int): Boolean {
    return bonusNumber in lottoNumber
}

fun gameRank(lottoNumber: Lotto, winningNumber: Pair<List<Int>, Int>): LottoRank {
    val (normalNumbers, bonusNumber) = winningNumber
    val normalNumberMatch = normalNumberMatch(lottoNumber, normalNumbers)
    val isBonusNumberMatch = bonusNumberMatch(lottoNumber, bonusNumber)
    return when {
        normalNumberMatch == LottoConstraints.FIRST_NORMAL_MATCH_COUNT -> LottoRank.FIRST
        (normalNumberMatch == LottoConstraints.SECOND_NORMAL_MATCH_COUNT) and isBonusNumberMatch -> LottoRank.SECOND
        normalNumberMatch == LottoConstraints.THIRD_NORMAL_MATCH_COUNT -> LottoRank.THIRD
        normalNumberMatch == LottoConstraints.FOURTH_NORMAL_MATCH_COUNT -> LottoRank.FOURTH
        normalNumberMatch == LottoConstraints.FIFTH_NORMAL_MATCH_COUNT -> LottoRank.FIFTH
        else -> LottoRank.NONE
    }
}