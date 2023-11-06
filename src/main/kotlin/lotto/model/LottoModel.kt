package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.ErrorMessage
import lotto.utils.Values
import kotlin.properties.Delegates

class LottoModel {
    private var lotteryAmount by Delegates.notNull<Int>()
    private var lotteryNumbers: ArrayList<List<Int>> = ArrayList()
    fun isPurchaseMoneyValueValid(moneyValue: String): Boolean {
        return try {
            if ((moneyValue.toInt() % Values.LOTTERY_PRICE) != 0) {
                throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROPRIATE_VALUE}")
            }
            setLotteryAmount(moneyValue)
            false
        } catch (e: IllegalArgumentException) {
            true
        }
    }
    @JvmName("callFromInt")
    fun getLotteryAmount(): Int {
        return lotteryAmount
    }
    fun getLotteryNumbers(): ArrayList<List<Int>> {
        return lotteryNumbers
    }
    fun setLotteryNumbers() {
        repeat(lotteryAmount) {
            setRandomLottery()
        }
    }
    private fun setLotteryAmount(moneyValue: String) {
        lotteryAmount = moneyValue.toInt() / Values.LOTTERY_PRICE
    }
    private fun setRandomLottery() {
        lotteryNumbers.add(Randoms.pickUniqueNumbersInRange(Values.MINIMUM_LOTTERY_NUMBER, Values.MAXIMUM_LOTTERY_NUMBER, Values.LOTTERY_NUMBER_AMOUNT).sorted())
    }
}