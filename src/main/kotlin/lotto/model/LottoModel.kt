package lotto.model

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
    private lateinit var winningLottery: WinningLottery
    private lateinit var lottoResult: LottoResult
    private var totalEarned = 0
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
            if(lotto.getNumbers().contains(bonusNumber.getBonusNumber())) {
                throw IllegalArgumentException("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_MONEY_VALUE}")
            }
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
    fun calculateWinningLottery() {
        for(item in lotteryNumbers) {
            when {
                lotto.getNumbers().toSet().intersect(item.toSet()).size == 6 -> lottoResult.first++
                (lotto.getNumbers().toSet().intersect(item.toSet()).size == 5) && (item.contains(bonusNumber.getBonusNumber())) -> lottoResult.second++
                lotto.getNumbers().toSet().intersect(item.toSet()).size == 5 -> totalEarned += lottoResult.third++
                lotto.getNumbers().toSet().intersect(item.toSet()).size == 4 -> totalEarned += lottoResult.fourth++
                lotto.getNumbers().toSet().intersect(item.toSet()).size == 3 -> totalEarned += lottoResult.fifth++
            }
        }
        print(totalEarned)
    }
}