package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

class LottoMachine {
    private val view = View()
    private lateinit var winningLotto: Lotto
    private val lottoList = mutableListOf<Lotto>()
    private var money = 0
    private var lottoCount = 0
    private val winningCount = mutableListOf<Int>(0, 0, 0, 0, 0)
    private var bonusNum = 0

    fun buyLotto() {
        view.printInputMoney()

        checkInputMoney(Console.readLine())

        calculateLottoCount(money)
        generateLotto(lottoCount)
    }

    fun checkInputMoney(input: String) {
        try {
            money = input.toInt()
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자만 입력하세요.")
        }
    }

    fun calculateLottoCount(money: Int) {
        try {
            if (money % 1000 != 0){
                throw IllegalArgumentException("1000원으로 나누어떨어지는 금액이 아닙니다.")
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            buyLotto()
        }
        lottoCount = money / 1000
    }
    fun generateLotto(lottoCount: Int) {
        for (i in 1..lottoCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            lottoList.add(Lotto(numbers))
        }
        purchasedLotto()
    }

    fun purchasedLotto() {
        view.printPurchasedLotto(lottoCount, lottoList)

        inputWinningNum()
    }

    fun inputWinningNum() {
        view.printInputWinningNum()

        val input = Console.readLine()
        val numList = parsingInput(input)

        checkWinningNumCount(numList)

        winningLotto = Lotto(numList)

        inputBonusNum()
    }

    fun checkWinningNumCount(numList: List<Int>) {
        try {
            if (numList.size != 6) {
                throw IllegalArgumentException("6개의 숫자를 입력해주세요.")
            }
        } catch (e: IllegalArgumentException) {
            println("[EEROR] ${e.message}")
            inputWinningNum()
        }
    }

    fun parsingInput(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toInt() }

        try {
            if (numbers.size != numbers.toSet().size) {
                throw IllegalArgumentException("중복된 숫자가 있습니다. 다시 입력해주세요.")
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            inputWinningNum()
        }

        return numbers
    }

    fun inputBonusNum() {
        view.printInputBonusNum()

        val input = Console.readLine()

        checkDuplicateBonusNumber(input)
        checkBonusNumInRange(input)

        bonusNum = input.toInt()

        winningSummary()
    }

    fun checkDuplicateBonusNumber(input: String) {
        val winningNum = winningLotto.getNum()

        try {
            if (winningNum.contains(input.toInt())) {
                throw IllegalArgumentException("중복된 숫자가 존재합니다. 다시 입력해주세요.")
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            inputBonusNum()
        }
    }

    fun checkBonusNumInRange(input: String) {
        try {
            if (input.toInt() > 45 || input.toInt() < 1) {
                throw IllegalArgumentException("보너스 번호는 1과 45사이의 숫자만 가능합니다.")
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            inputBonusNum()
        }
    }

    fun winningSummary() {
        view.printWinningSummaryTitle()

        calculateWinningCount()

        val profitRate = caculateProfitRate()
        view.printWinningSummary(winningCount, profitRate)
    }

    fun calculateWinningCount() {
        for (lotto in lottoList) {
            val count = compareLotto(lotto.getNum())
            val isBonus = lotto.getNum().contains(bonusNum)
            updateWinningCount(count, isBonus)
        }
    }

    fun updateWinningCount(count: Int, isBonus: Boolean) {
        when(count) {
            3 -> winningCount[0]++
            4 -> winningCount[1]++
            5 -> {
                if (isBonus) {
                    winningCount[3]++
                    return
                }
                winningCount[2]++
            }
            6 -> winningCount[4]++
        }
    }

    fun compareLotto(myLotto: List<Int>): Int {
        val myLottoSet = myLotto.toSet()
        val winningLottoSet = winningLotto.getNum().toSet()
        val intersection = myLottoSet.intersect(winningLottoSet)

        return intersection.size
    }

    fun caculateProfitRate(): String {
        var sum = 0

        sum += LottoWinningType.FIFTH.winningAmount * winningCount[0]
        sum += LottoWinningType.FOURTH.winningAmount * winningCount[1]
        sum += LottoWinningType.THIRD.winningAmount * winningCount[2]
        sum += LottoWinningType.SECOND.winningAmount * winningCount[3]
        sum += LottoWinningType.FIRST.winningAmount * winningCount[4]

        val profitRate = (sum * 100 / money.toDouble())

        return String.format("%.1f", profitRate)
    }
}