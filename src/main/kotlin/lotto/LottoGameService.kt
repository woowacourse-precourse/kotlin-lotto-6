package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants.Companion.ERROR_INVALID_LOTTO_AMOUNT_EXCEPTION
import lotto.Constants.Companion.LOTTO_PRICE
import lotto.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_NUMBER

class LottoGameService {
    fun calculateLottoPurchaseQuantity(purchaseAmount: Int): Int {
        require(purchaseAmount % LOTTO_PRICE == MIN_NUMBER){ ERROR_INVALID_LOTTO_AMOUNT_EXCEPTION }
        return purchaseAmount / LOTTO_PRICE
    }
    fun lottoNumberGenerator(ticket: Int): MutableMap<Int, List<Int>> {
        val purchaseLottoLists = mutableMapOf<Int,List<Int>>()
        for (ticketCheck in 0 until ticket) {
            purchaseLottoLists[ticketCheck] = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, 6).sorted()
        }
        return purchaseLottoLists
    }
    private fun checkWinningLottoNumber(lotto: List<Int>, randomLottoLists: MutableMap<Int, List<Int>>, ticketCheck: Int): Int {
        return randomLottoLists[ticketCheck]!!.intersect(lotto.toSet()).count()
    }
    private fun checkWinningBonusNumber(bonus: Int, randomLottoLists: MutableMap<Int, List<Int>>, ticketCheck: Int): Boolean {
        return randomLottoLists[ticketCheck]!!.contains(bonus)
    }
}