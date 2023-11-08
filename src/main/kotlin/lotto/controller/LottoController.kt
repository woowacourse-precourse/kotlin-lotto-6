package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.Constant.BONUS_NUMBER_REGEX
import lotto.constant.Constant.EQUAL_MESSAGE
import lotto.constant.Constant.INPUT_WIN_NUMBER_REGEX
import lotto.constant.Constant.LOTTO_LENGTH
import lotto.constant.Constant.MAX_LOTTO_NUM
import lotto.constant.Constant.MIN_LOTTO_NUM
import lotto.constant.Constant.NUMBER_MESSAGE
import lotto.constant.Constant.PURCHASE_DIVISOR
import lotto.constant.Constant.THREE_PRIZE
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun play() {
        val buyAmount = buyLotto()
        val lotteries = makeLotteries(buyAmount)
        val userLotto = lottoParser()
        val userBonusNumber = bonusNumParser()
        val win = prize(userLotto, lotteries, userBonusNumber)
        var winPrize = 0
        println("${win[0]}" + EQUAL_MESSAGE + THREE_PRIZE + " - " + NUMBER_MESSAGE)


    }
    fun prize(userLotto : MutableList<Int>, lotteries : MutableList<Lotto>, userBonusNumber : Int ) : List<Int>{
        var countForThree = 0
        var countForFour = 0
        var countForFive = 0
        var countForFiveAndBonus = 0
        var countForSix = 0
        for (lotto in lotteries) {
            when (compare(lotto, userLotto))
            {
                3 ->
                {
                    countForThree++
                }
                4 ->
                {
                    countForFour++
                }
                5 ->
                {
                    if (checkBonus(userBonusNumber, lotto)) {
                        countForFiveAndBonus++
                    } else {
                        countForFive++
                    }
                }
                6 ->
                {
                    countForSix++
                }
            }
        }
        return listOf(countForThree, countForFour, countForFive, countForFiveAndBonus, countForSix,
            countForThree * 5000 + countForFour * 50000 + countForFive * 1500000 + countForFiveAndBonus * 30000000
        + countForSix * 2000000000)
    }
    private fun checkBonus (userBonusNumber : Int, lotto : Lotto ) : Boolean {
        return userBonusNumber in lotto.getNUmber()
    }
    fun compare(lotto: Lotto, userLotto : MutableList<Int>) : Int {
        var count = 0
        val objectiveLotto = lotto.getNUmber()
        for ( number in userLotto ) {
            if (number in objectiveLotto) {
                count++
            }
        }
        return count
    }

    private fun makeLotteries(buyAmount: Int) : MutableList<Lotto>{
        val lotteries = mutableListOf<Lotto>()
        for (idx in 0 until buyAmount) {
            lotteries.add(makeLotto())
        }
        return lotteries
    }
    private fun makeLotto() : Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_LENGTH)
        val lotto = Lotto(numbers)
        println(lotto)
        return lotto
    }
    private fun buyLotto() : Int {
        inputView.buyAmountMessage()
        val buyAmount = Console.readLine()
        try {
            val buyAmountNum = buyAmount.toInt()
            val buyNumber = purchase(buyAmountNum)
            outputView.buyNumberMessage(buyNumber)
            return buyNumber
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }

    }
    fun purchase ( buyAmount : Int ) : Int {
        require(buyAmount % PURCHASE_DIVISOR != 0)
        return buyAmount / PURCHASE_DIVISOR
    }
    private fun lottoParser(): MutableList<Int> {
        inputView.inputWinNumber()
        val appliedLotto = Console.readLine()
        regexCheck(appliedLotto, INPUT_WIN_NUMBER_REGEX)
        return duplicateCheck(appliedLotto)
    }
    private fun bonusNumParser(): Int {
        inputView.bonusNumberMessage()
        val bonusNumber = Console.readLine()
        regexCheck(bonusNumber, BONUS_NUMBER_REGEX)
        return duplicateCheck(bonusNumber)[0]
    }
    private fun regexCheck(lotto:String, regex : String) {
        return require(lotto.matches(Regex(regex)))
    }
    private fun duplicateCheck(lotto:String) : MutableList<Int> {
        val lottoNumbers = lotto.split(',')
        val prevNum = HashSet<String>()
        val userLottoNumbers = mutableListOf<Int>()
        for (number in lottoNumbers) {
            if (prevNum.contains(number)) {
                throw IllegalArgumentException()
            }
            prevNum.add(number)
            userLottoNumbers.add(number.toInt())
        }
        return userLottoNumbers
    }
}