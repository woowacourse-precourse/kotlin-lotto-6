package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 총 6개여야 합니다." }
    }

    private fun readBoughtAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val boughtAmount = Console.readLine().toInt()
        require(boughtAmount % 1000 == 0) { "금액은 1000단위여야 합니다." }
        // 구입금액을 1000으로 나눈 나머지가 구입한 로또의 개수
        return boughtAmount % 1000
    }

    private fun readWinningNumber(): List<Int> {
        val winningNumbers = Console.readLine().split(',').toMutableList()
        val winningNumbersToInt = winningNumbers.map { it.toInt() }
        // winnigNumbersToInt의 모든 요소가 1~45의 값인지 확인하고 아니라면 예외처리
        for (i in winningNumbersToInt) {
            require(i in 1..45) { "당첨숫자는 1~45의 숫자이어야 합니다." }
        }
        return winningNumbersToInt.sorted()
    }

    fun printBoughtLotto() {
        println("${readBoughtAmount()}개를 구매했습니다.")
        for (i in 0..readBoughtAmount()-1){
            println("${readWinningNumber()}")
        }
        print("\n")
    }

}
