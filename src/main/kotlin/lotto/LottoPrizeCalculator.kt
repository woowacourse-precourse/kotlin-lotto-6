//package lotto
//
//// 메서드 분리: when (lottoNumberMatch)로 인덱스를 반환하는 메서드
//// when (lottoNumberMatch)로 totalPrize를 반환하는 메서드
//class LottoPrizeCalculator {
//    fun calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts: List<List<Int>>, winningLotteryNumbers: List<Int>, bonusNumber: Int, prizeCounts: IntArray): Int {
//        var totalPrize = 0
//
//        for (i in 0 until lottoPurchaseCounts.size) {
//            val union = lottoPurchaseCounts[i] + winningLotteryNumbers
//            val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
//            var lottoNumberMatch = intersection.size
//            var bonusNumberMatch = lottoPurchaseCounts[i].contains(bonusNumber)
//
//            if (bonusNumberMatch && lottoNumberMatch == 4) {
//                bonusNumberMatch = false
//                lottoNumberMatch++
//            }
//            if (bonusNumberMatch && lottoNumberMatch != 5) {
//                lottoNumberMatch++
//            }
//
//            when (lottoNumberMatch) {
//                6 -> {
//                    prizeCounts[4]++
//                    totalPrize += 2000000000
//                }
//
//                5 -> {
//                    if (bonusNumberMatch) {
//                        prizeCounts[3]++
//                        totalPrize += 30000000
//                    } else {
//                        prizeCounts[2]++
//                        totalPrize += 1500000
//                    }
//                }
//
//                4 -> {
//                    prizeCounts[1]++
//                    totalPrize += 50000
//                }
//
//                3 -> {
//                    prizeCounts[0]++
//                    totalPrize += 5000
//                }
//            }
//
//        }
//        return totalPrize
//    }
//}


package lotto

class LottoPrizeCalculator {
    var lottoNumberMatch = 0
    var bonusNumberMatch = false

    fun calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts: List<List<Int>>, winningLotteryNumbers: List<Int>, bonusNumber: Int, prizeCounts: IntArray): Int {
        var totalPrize = 0

        for (i in 0 until lottoPurchaseCounts.size) {
            val union = lottoPurchaseCounts[i] + winningLotteryNumbers
            val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            lottoNumberMatch = intersection.size
            bonusNumberMatch = lottoPurchaseCounts[i].contains(bonusNumber)

            changeNumberMatch()

            totalPrize += calculatePrizeAndIncrementCount(lottoNumberMatch, prizeCounts)

        }
        return totalPrize
    }

    private fun changeNumberMatch() {
        if (bonusNumberMatch && lottoNumberMatch == 4) {
            bonusNumberMatch = false
            lottoNumberMatch++
        }
        if (bonusNumberMatch && lottoNumberMatch != 5) {
            lottoNumberMatch++
        }

    }

    private fun calculatePrizeAndIncrementCount(
            lottoNumberMatch: Int,
            prizeCounts: IntArray
    ): Int {
        val prizeIndex = when (lottoNumberMatch) {
            6 -> 4
            5 -> if (prizeCounts[3] > 0) 3 else 2
            4 -> 1
            3 -> 0
            else -> -1
        }

        if (prizeIndex >= 0) {
            prizeCounts[prizeIndex]++
            return calculatePrizeForMatch(lottoNumberMatch)
        }

        return 0
    }

    private fun calculatePrizeForMatch(lottoNumberMatch: Int): Int {
        return when (lottoNumberMatch) {
            6 -> 2_000_000_000
            5 -> 30_000_000
            4 -> 1_500_000
            3 -> 5_000
            else -> 0
        }
    }
}