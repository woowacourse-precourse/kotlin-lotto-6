package lotto.util

object FormatUtil {
    fun formatEarningRate(earningRate: Double): String {
        return String.format("%,.1f", earningRate)
    }

    fun formatReward(reward: Int): String {
        return String.format("%,d", reward)
    }

}