package lotto.model

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.ErrorMessage
import lotto.utils.Values
import java.lang.NumberFormatException
import kotlin.properties.Delegates

class LottoModel {
    private var lotteryAmount by Delegates.notNull<Int>()
    private var lotteryNumbers: ArrayList<List<Int>> = ArrayList()
    private lateinit var lotto: Lotto
    private lateinit var bonusNumber: BonusNumber
    private var benefitMoney by Delegates.notNull<Int>()
    fun isPurchaseMoneyValueValid(moneyValue: String): Boolean {
        return try {
            if ((moneyValue.toInt() % Values.LOTTERY_PRICE) != 0) {
                throw IllegalArgumentException("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_MONEY_VALUE}")
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
    private fun setLotteryAmount(moneyValue: String) {
        lotteryAmount = moneyValue.toInt() / Values.LOTTERY_PRICE
    }
    fun getLotteryNumbers(): ArrayList<List<Int>> {
        return lotteryNumbers
    }
    fun setLotteryNumbers() {
        repeat(lotteryAmount) {
            setRandomLottery()
        }
    }
    private fun setRandomLottery() {
        lotteryNumbers.add(Randoms
                .pickUniqueNumbersInRange(Values.MINIMUM_LOTTERY_NUMBER,
                        Values.MAXIMUM_LOTTERY_NUMBER,
                        Values.LOTTERY_NUMBER_AMOUNT)
                .sorted())
    }
    fun setLotto(winningNumbers: List<String>): Boolean {
        return try {
            lotto = Lotto(winningNumbers.map { it.toInt() }.map { it })
            false
        } catch (e: IllegalArgumentException) {
            true
        }
    }
    fun setBonus(bonus: String): Boolean {
        return try {
            bonusNumber = BonusNumber(bonus.toInt())
            false
        } catch (e: Exception) {
            when (e) {
                is NumberFormatException, is IllegalArgumentException -> {
                    true
                }
                else -> throw e
            }
        }
    }
    fun checkRate() {
        for(item in lotteryNumbers) {

        }
    }
}