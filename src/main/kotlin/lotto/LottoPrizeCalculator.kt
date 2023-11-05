package lotto

class LottoPrizeCalculator {
    fun calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts: List<List<Int>>, winningLotteryNumbers: List<Int>, bonusNumber: Int, prizeCounts: IntArray): Int {
        var totalPrize = 0

        for (i in 0 until lottoPurchaseCounts.size) {
            val union = lottoPurchaseCounts[i] + winningLotteryNumbers
            val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            var lottoNumberMatch = intersection.size
            val bonusNumberMatch = lottoPurchaseCounts[i].contains(bonusNumber)

            if (bonusNumberMatch && lottoNumberMatch != 5) {
                lottoNumberMatch++
            }

            when (lottoNumberMatch) {
                6 -> {
                    prizeCounts[4]++
                    totalPrize += 2000000000
                }

                // 수정할 것: 당첨 번호에서 4개 맞추고 보너스 번호를 맞춘 경우엔 5개 일치가 나와야 하는데
                // 5개 일치, 보너스 볼 일치가 나옴..
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