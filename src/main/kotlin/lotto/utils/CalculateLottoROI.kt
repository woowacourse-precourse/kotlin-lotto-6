package lotto.utils

fun calculateLottoROI(investment: Double, winnings: Double): String {
    val roi = (winnings / investment) * 100.0
    return String.format("%.1f", roi)
}