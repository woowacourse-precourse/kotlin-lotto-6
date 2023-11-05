package lotto

class LottoPrizeCalculator {
    fun calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts: List<List<Int>>, winningLotteryNumbers: List<Int>, bonusNumber: Int, prizeCounts: IntArray): Int {
        var totalPrize = 0

        for (i in 0 until lottoPurchaseCounts.size) {
            val union = lottoPurchaseCounts[i] + winningLotteryNumbers
            val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            var lottoNumberMatch = intersection.size
            var bonusNumberMatch = lottoPurchaseCounts[i].contains(bonusNumber)

            if (bonusNumberMatch && lottoNumberMatch == 4) {
                bonusNumberMatch = false
                lottoNumberMatch++
            }
            if (bonusNumberMatch && lottoNumberMatch != 5) {
                lottoNumberMatch++
            }

            when (lottoNumberMatch) {
                6 -> {
                    prizeCounts[4]++
                    totalPrize += 2000000000
                }

                5 -> {
                    if (bonusNumberMatch) {
                        prizeCounts[3]++
                        totalPrize += 30000000
                    } else {
                        prizeCounts[2]++
                        totalPrize += 1500000
                    }
                }

                4 -> {
                    prizeCounts[1]++
                    totalPrize += 50000
                }

                3 -> {
                    prizeCounts[0]++
                    totalPrize += 5000
                }
            }

        }
        return totalPrize
    }
}