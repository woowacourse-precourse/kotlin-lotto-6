package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    fun initializeLotto(): Tuple {
        var amount: Int
        var lottoPurchaseCount: Int
        val prizeCounts = IntArray(5)

        while (true) {
            println(MessageConstants.INPUT_PURCHASE_AMOUNT)
            try {
                amount = Console.readLine().toInt()
                if (amount < 1000) {
                    throw IllegalArgumentException(MessageConstants.ERROR_AMOUNT_LESS_THAN_1000)
                } else if (amount % 1000 != 0) {
                    throw IllegalArgumentException(MessageConstants.ERROR_NOT_A_MULTIPLE_OF_1000)
                } else {
                    break
                }
            } catch (e: NumberFormatException) {
                println(MessageConstants.ERROR_NOT_A_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        lottoPurchaseCount = amount / 1000
        println("\n${lottoPurchaseCount}${MessageConstants.PURCHASE_COMPLETED}")
        return Tuple(amount, lottoPurchaseCount, prizeCounts)
    }
}