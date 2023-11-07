package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private fun readBoughtAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val boughtAmount = Console.readLine().toInt()
        require(boughtAmount % 1000 == 0) { "[ERROR] 금액은 1000단위여야 합니다." }
        // 구입금액을 1000으로 나눈 나머지가 구입한 로또의 개수
        return boughtAmount % 1000
    }

    private fun readWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine().split(',').toMutableList()
        val winningNumbersToInt = winningNumbers.map { it.toInt() }
        // winnigNumbersToInt의 모든 요소가 1~45의 값인지 확인하고 아니라면 예외처리
        for (i in winningNumbersToInt) {
            require(i in 1..45) {
                "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
            }
        }
        return winningNumbersToInt.sorted()
    }

    private fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine().toInt()
        require(bonusNumber in 1..45) {
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        }
        return bonusNumber
    }

    fun printBoughtLotto() {
        println("${readBoughtAmount()}개를 구매했습니다.")
        for (i in 0..readBoughtAmount() - 1) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println("$lottoNumbers")
        }

        print("\n")
    }

    fun printWinningDetails(winningMap: MutableMap<Int, Int>, numberOfLottos: Int) {
        println("3개 일치 (5,000원) - ${winningMap[3]}개")
        println("4개 일치 (50,000원) - ${winningMap[4]}개")
        println("5개 일치 (1,500,000원) - ${winningMap[5]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningMap[0]}개")
        println("6개 일치 (2,000,000,000원) - ${winningMap[6]}개")
        val profitRate = (5000 * winningMap[3]!! + 50000 * winningMap[4]!! + 1500000 * winningMap[5]!!
                + 30000000 * winningMap[0]!! + 2000000000 * winningMap[6]!!) / (numberOfLottos * 1000)
        println ("총 수익률은 ${profitRate}%입니다.")
    }

    private fun gameStart() {
        val numberOfLottos = readBoughtAmount()
        val winningNumbers = readWinningNumber()
        val bonusNumber = readBonusNumber()
        val winningMap = mutableMapOf(0 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)

        println("${numberOfLottos}개를 구매했습니다.")
        for (i in 0..readBoughtAmount() - 1) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println("$lottoNumbers")
            val lotto = Lotto(
                lottoNumbers,
                winningNumbers,
                bonusNumber
            )
            winningMap[lotto.winningJudge()] = winningMap[lotto.winningJudge()]!! + 1
        }
        printWinningDetails(winningMap, numberOfLottos)
    }
}