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
    // 랜덤 로또 번호 리스트와 입력한 로또 번호를 비교해주는 함수
    fun calculateWinningStatistics(
        lotto: List<Int>,
        bonus: Int,
        randomLottoLists: MutableMap<Int, List<Int>>,
        ticket: Int
    ) {
        for (ticketCheck in 0 until ticket){
            val winningLottoCheck = checkWinningLottoNumber(lotto, randomLottoLists, ticketCheck)
            val bonusNumberCheck = checkWinningBonusNumber(bonus, randomLottoLists, ticketCheck)
            saveWinningStatsToRank(winningLottoCheck,bonusNumberCheck,ticketCheck)
        }
    }
    // 랜덤 로또 리스트에 입력한 로또 번호가 몇개 포함되어 있는지 확인하는 함수
    private fun checkWinningLottoNumber(lotto: List<Int>, randomLottoLists: MutableMap<Int, List<Int>>, ticketCheck: Int): Int {
        return randomLottoLists[ticketCheck]!!.intersect(lotto.toSet()).count()
    }
    private fun checkWinningBonusNumber(bonus: Int, randomLottoLists: MutableMap<Int, List<Int>>, ticketCheck: Int): Boolean {
        return randomLottoLists[ticketCheck]!!.contains(bonus)
    }
}