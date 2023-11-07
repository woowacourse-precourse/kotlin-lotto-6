// LottoTicketPurchase.kt
package lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoTicketPurchase {
    companion object {
        private const val INITIAL_NUM = 0
        private const val LIST_SIZE = 6
        private const val RANDOM_NUM_START = 1
        private const val RANDOM_NUM_END = 45
    }
    fun purchaseLottoTickets(lottoPurchaseCount: Int): MutableList<List<Int>> {
        val lottoPurchaseCounts = List(lottoPurchaseCount) { List(LIST_SIZE) { INITIAL_NUM } }.toMutableList()
        for (i in INITIAL_NUM until lottoPurchaseCount) {
            val randomNumbers = Randoms.pickUniqueNumbersInRange(RANDOM_NUM_START, RANDOM_NUM_END, LIST_SIZE)
            lottoPurchaseCounts[i] = randomNumbers.sorted()
            println(randomNumbers.sorted())
        }
        return lottoPurchaseCounts
    }
}
