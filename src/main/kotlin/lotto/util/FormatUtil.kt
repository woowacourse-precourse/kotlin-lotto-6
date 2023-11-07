package lotto.util

object FormatUtil {

    fun formatReward(reward: Int): String {
        return String.format("%,d", reward)
    }

    fun formatEarningRate(earningRate: Double): String {
        return String.format("%,.1f", earningRate)
    }
}