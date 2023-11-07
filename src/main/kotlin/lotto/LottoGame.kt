package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private fun readBoughtAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val boughtAmount = Console.readLine()
        try {
            boughtAmount.toInt()
        } catch(ex:NumberFormatException){
            throw IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.")
        }
        val boughtAmountToInt = boughtAmount.toInt()
        require(boughtAmountToInt % 1000 == 0) { "[ERROR] 금액은 1000단위여야 합니다." }

        // 구입금액을 1000으로 나눈 나머지가 구입한 로또의 개수
        return boughtAmountToInt / 1000
    }

    private fun readWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine().split(',').toMutableList()
        val winningNumbersToInt = winningNumbers.map { it.toInt() }
        for (i in winningNumbersToInt) {
            require(i in 1..45) {
                "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
            }
        }
        require(winningNumbersToInt.size == 6) { "[ERROR] 당첨 번호는 6개의 숫자여야 합니다." }
        require(winningNumbers.toSet().size == winningNumbersToInt.size) { "[ERROR] 중복이 없어야 합니다." }
        return winningNumbersToInt.sorted()
    }

    private fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()
        try {
            bonusNumber.toInt()
        } catch (ex: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 정수만 입력해야 합니다")
        }
        val bonusNumberToInt = bonusNumber.toInt()
        require(bonusNumberToInt in 1..45) {
            "[ERROR] 1부터 45 사이의 숫자여야 합니다."
        }
        return bonusNumberToInt
    }

    private fun printWinningDetails(winningMap: MutableMap<Int, Int>, numberOfLottos: Int) {
        println("3개 일치 (5,000원) - ${winningMap[3]}개")
        println("4개 일치 (50,000원) - ${winningMap[4]}개")
        println("5개 일치 (1,500,000원) - ${winningMap[5]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningMap[-1]}개")
        println("6개 일치 (2,000,000,000원) - ${winningMap[6]}개")
        val profitRate: Float =
            (5000 * winningMap[3]!! + 50000 * winningMap[4]!! + 1500000 * winningMap[5]!!
                    + 30000000 * winningMap[-1]!! + 2000000000 * winningMap[6]!!).toFloat() / (numberOfLottos * 1000)
        println("총 수익률은 ${profitRate}%입니다.")
    }

    fun gameStart() {
        val numberOfLottos = readBoughtAmount()
        val winningNumbers = readWinningNumber()
        val bonusNumber = readBonusNumber()
        // 3: 3개적중, 4: 4개적중, 5: 5개적중(보너스x), 6: 6개적중, -1: 5개적중(보너스)
        val winningMap =
            mutableMapOf(-1 to 0, 0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)

        println("${numberOfLottos}개를 구매했습니다.")
        for (i in 0..numberOfLottos - 1) {
            val lottoNumbers =
                Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            println("$lottoNumbers")
            val lotto = Lotto(
                lottoNumbers,
                winningNumbers,
                bonusNumber
            )
            val winning = lotto.winningJudge()
            winningMap[winning] = winningMap[winning]!! + 1
        }
        printWinningDetails(winningMap, numberOfLottos)
    }
}