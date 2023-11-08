package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    private var purchaseAmount: Int = 0
    private val prizeCounts = IntArray(ARRAYS_SIZE)
    private var lottoPurchaseCount: Int = 0
    companion object {
        private const val LOTTO_UNIT = 1000
        private const val ARRAYS_SIZE = 5
    }
    fun initializeLotto(): Tuple {
        inputPurchaseAmount()

        lottoPurchaseCount = purchaseAmount / LOTTO_UNIT
        println("\n${lottoPurchaseCount}${MessageConstants.PURCHASE_COMPLETED}")
        return Tuple(purchaseAmount, lottoPurchaseCount, prizeCounts)
    }

    fun inputPurchaseAmount() {
        while (true) {
            println(MessageConstants.INPUT_PURCHASE_AMOUNT)
            try {
                purchaseAmount = Console.readLine().toInt()
                if (PurchaseAmount().validateLottoNumbers(purchaseAmount))
                    break
            } catch (e: NumberFormatException) {
                println(MessageConstants.ERROR_NOT_A_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}