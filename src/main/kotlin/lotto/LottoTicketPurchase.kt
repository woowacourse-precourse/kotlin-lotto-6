// LottoTicketPurchase.kt
package lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoTicketPurchase {
    fun purchaseLottoTickets(lottoPurchaseCount: Int): MutableList<List<Int>> {
        val lottoPurchaseCounts = List(lottoPurchaseCount) { List(6) { 0 } }.toMutableList()
        for (i in 0 until lottoPurchaseCount) {
            val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoPurchaseCounts[i] = randomNumbers.sorted()
            println(randomNumbers.sorted())
        }
        return lottoPurchaseCounts
    }
}
