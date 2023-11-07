package lotto

class Lotto(private val numbers: List<Int>) {
    // 로또 번호가 유효한 숫자들인지 검증
    init {
        require(numbers.size == 6) {
            "로또는 숫자 6개 입니다."
        }
        require(numbers.distinct().size == 6) {
            "로또의 숫자는 서로 중복되지 않습니다."
        }
        require(numbers.all { it in 1..45 }) {
            "로또는 1부터 45 중에서 결정됩니다."
        }
    }
    // TODO: 추가 기능 구현
    // 사용자가 구매한 로또와 당첨 번호가 얼마나 일치하는지 계산
    fun match(winningNums: List<Int>): Int {
        require(winningNums.size == 6) {
            "당첨 번호는 6개의 중복되지 않은 수입니다."
        }
        return numbers.count { it in winningNums }
    }

    // 보너스 숫자 검증
    fun bonusNum(bonusNum: Int): Boolean {
        require(bonusNum in 1..45) {
            "보너스 숫자는 1부터 45 중에 있습니다."
        }
        return bonusNum in numbers
    }

    // 당첨 결과에 따른 통계 출력
    fun printStat() {
        val stat = numbers.groupBy { it }
        println("3개 일치 (5,000원) - ${stat[3] ?: 0}개")
        println("4개 일치 (50,000원) - ${stat[4] ?: 0}개")
        println("5개 일치 (1,500,000원) - ${stat[5] ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${stat[5 + 1] ?: 0}개")
        println("6개 일치 (2,000,000,000원) - ${stat[6] ?: 0}개")
    }

    // 수익률 반환 함수
    fun rateReturn(money: Int): String {
        val winningMoney = mapOf(
            3 to 5000, 4 to 50000, 5 to 1500000, 5 + 1 to 3000000, 6 to 2000000000
        )
        val totalMoney = numbers.sumOf { winningMoney[it] ?: 0 }
        val rate = totalMoney.toDouble() / money.toDouble() * 100 // 수익률 계산
        return "%.2f%%".format(rate)
    }

    fun matchBonus(matchCount: Int, isBonus: Boolean) {
        if (matchCount == 5 && isBonus) {
            numbers.a
        }
    }
}
