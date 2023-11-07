package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private fun readBoughtAmount(): Int {
        println("구입금액을 입력해 주세요.")
        var boughtAmount: String
        while (true) {
            boughtAmount = Console.readLine()
            try {
                require(boughtAmount.toInt() % UnitAmount.unit.price == 0)
                break
            } catch (ex: IllegalArgumentException) {
                println("[ERROR] 정수가 아니거나 1000단위가 아닙니다.")
                println("구입 금액을 다시 입력해 주세요.")
            }
        }
        val boughtAmountToInt = boughtAmount.toInt()
        print("\n")
        // 구입금액을 1000으로 나눈 나머지가 구입한 로또의 개수
        return boughtAmountToInt / UnitAmount.unit.price
    }

    private fun printBoughtLottos(
        numberOfLottos: Int,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): MutableMap<Int, Int> {
        println("${numberOfLottos}개를 구매했습니다.")
        // 3: 3개적중, 4: 4개적중, 5: 5개적중(보너스x), 6: 6개적중, -1: 5개적중(보너스)
        val winningMap =
            mutableMapOf(-1 to 0, 0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
        for (i in 0..numberOfLottos - 1) {
            val lottoNumbers =
                Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            println("$lottoNumbers")
            val lotto = Lotto(lottoNumbers, winningNumbers, bonusNumber)
            val winning = lotto.winningJudge()
            winningMap[winning] = winningMap[winning]!! + 1
        }
        return winningMap
    }

    private fun readWinningNumberExceptionHandling(winningNumbersToInt: List<Int>) {
        for (winningNumber in winningNumbersToInt) {
            require(winningNumber in 1..45)
        }
    }

    private fun readWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        var winningNumbersToInt: List<Int>
        while (true) {
            val winningNumbers = Console.readLine().split(',').toMutableList()
            try {
                winningNumbersToInt = winningNumbers.map { it.toInt() }
                readWinningNumberExceptionHandling(winningNumbersToInt)
                require(winningNumbersToInt.size == 6)
                require(winningNumbers.toSet().size == winningNumbersToInt.size)
                break
            } catch (ex: IllegalArgumentException) {
                println("[ERROR] 정수가 아니거나 1~45가 아니거나 6개가 아니거나 중복이 있습니다.")
                println("다시 입력해주세요.")
            }
        }
        print("\n")
        return winningNumbersToInt
    }

    private fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        var bonusNumberToInt: Int
        while (true) {
            val bonusNumber = Console.readLine()
            try {
                bonusNumberToInt = bonusNumber.toInt()
                require(bonusNumberToInt in 1..45)
                require(bonusNumberToInt !in winningNumbers)
                break
            } catch (ex: IllegalArgumentException) {
                println("[ERROR] 정수가 아니거나 1~45가 아니거나 당첨번호와 중복입니다.")
                println("다시 입력해주세요.")
            }
        }
        print("\n")
        return bonusNumberToInt
    }

    private fun printWinningDetails(winningMap: MutableMap<Int, Int>, numberOfLottos: Int) {
        println("3개 일치 (5,000원) - ${winningMap[3]}개")
        println("4개 일치 (50,000원) - ${winningMap[4]}개")
        println("5개 일치 (1,500,000원) - ${winningMap[5]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningMap[-1]}개")
        println("6개 일치 (2,000,000,000원) - ${winningMap[6]}개")
        val profitRate: Float =
            (
                    WinningAmounts.threeMatch.amounts * winningMap[3]!! +
                            WinningAmounts.fourMatch.amounts * winningMap[4]!! +
                            WinningAmounts.fiveMatch.amounts * winningMap[5]!! +
                            WinningAmounts.fiveAndBonus.amounts * winningMap[-1]!! +
                            WinningAmounts.sixMatch.amounts * winningMap[6]!!).toFloat() /
                    (numberOfLottos * UnitAmount.unit.price) * 100
        println(String.format("총 수익률은 %.1f%%입니다.", profitRate))
    }

    fun gameStart() {
        val numberOfLottos = readBoughtAmount()
        val winningNumbers = readWinningNumber()
        val bonusNumber = readBonusNumber(winningNumbers)
        val winningMap = printBoughtLottos(numberOfLottos, winningNumbers, bonusNumber)
        printWinningDetails(winningMap, numberOfLottos)
    }
}