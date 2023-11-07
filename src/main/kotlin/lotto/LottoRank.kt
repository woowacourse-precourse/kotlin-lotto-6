package lotto

enum class LottoRank(val prize: Long) {
    FIRST(2_000_000_000),
    SECOND(30_000_000), // Assuming 5 matches + bonus number
    THIRD(1_500_000), // 5 matches without bonus number
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);
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
        normalNumberMatch == 6 -> LottoRank.FIRST
        (normalNumberMatch == 5) and isBonusNumberMatch -> LottoRank.SECOND
        normalNumberMatch == 5 -> LottoRank.THIRD
        normalNumberMatch == 4 -> LottoRank.FOURTH
        normalNumberMatch == 3 -> LottoRank.FIFTH
        else -> LottoRank.NONE
    }
}