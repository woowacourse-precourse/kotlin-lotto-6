package lotto

// 컴퓨터가 랜덤으로 돌려준 로또 번호들
// 즉 당첨번호가 아니다. 주의할 것
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compareCountingMatchedWinningNumber(winningNumber: WinningAndBonusNumber): Int {
        return (numbers.toSet().intersect(winningNumber.winningNumber.toSet()).size)
    }

    fun compareCountingMatchedBonusNumber(bonusNumber: WinningAndBonusNumber): Boolean {
        return numbers.toSet().intersect(bonusNumber.bonusNumber.toSet()).size == 1
    }

    fun divideStandard1to6(win: Int, bonus: Boolean) : Int {

        val checkValue = listOf(win, bonus)

        return when (checkValue) {
            listOf(3,false) -> 0
            listOf(3,true) -> 0
            listOf(3,false) -> 1
            listOf(4,true) -> 1
            listOf(5,false) -> 2
            listOf(5,true) -> 3
            listOf(6,false) -> 4
            else -> 5
        }
    }
}
