package lotto.model

import kotlin.math.round
import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.ErrorMessage
import lotto.utils.Values
import java.lang.NumberFormatException

class LottoModel {
    private var lotteryAmount = 0
    private var purchasePrice = 0
    private var lotteryNumbers: ArrayList<List<Int>> = ArrayList()
    private lateinit var lotto: Lotto
    private lateinit var bonusNumber: BonusNumber
    private var lottoResult = LottoResult()
    private var totalEarned: Long = 0
    private var benefitRate: Double = 0.0
    fun isPurchaseMoneyValueValid(moneyValue: String): Boolean {
        return try {
            if ((moneyValue.toInt() % Values.LOTTERY_PRICE) != 0) {
                throw IllegalArgumentException("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_MONEY_VALUE}")
            }
            setPurchasePrice(moneyValue.toInt())
            setLotteryAmount(moneyValue)
            false
        } catch (e: IllegalArgumentException) {
            true
        }
    }
    fun getPurchasePrice(): Int {
        return purchasePrice
    }
    fun setPurchasePrice(price: Int) {
        purchasePrice = price
    }
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
        } catch (e: NumberFormatException) {
            true
        } catch (e: IllegalArgumentException) {
            true
        }
    }
    fun getLottoResult(): LottoResult {
        return lottoResult
    }
    fun calculateWinningLottery() {
        for(item in lotteryNumbers) {
            calculateLottoCondition(lotto.getNumbers().toSet().intersect(item.toSet()).size, (item.contains(bonusNumber.getBonusNumber())))
        }
    }
    private fun calculateLottoCondition(matchAmount: Int, isBonusActive: Boolean) {
        when {
            matchAmount == 6 -> {
                lottoResult.first++
                totalEarned += Values.WINNING_PRIZE_FIRST
            }
            (matchAmount == 5) && isBonusActive -> {
                lottoResult.second++
                totalEarned += Values.WINNING_PRIZE_SECOND
            }
            (matchAmount == 5) && !isBonusActive -> {
                lottoResult.third++
                totalEarned += Values.WINNING_PRIZE_THIRD
            }
            matchAmount == 4 -> {
                lottoResult.fourth++
                totalEarned += Values.WINNING_PRIZE_FOURTH
            }
            matchAmount == 3 -> {
                lottoResult.fifth++
                totalEarned += Values.WINNING_PRIZE_FIFTH
            }
        }
    }
    fun getBenefitRate(): Double {
        return benefitRate
    }
    fun setBenefitRate() {
        benefitRate = round(totalEarned.toDouble() / getPurchasePrice() * 1000) / 10
    }
}