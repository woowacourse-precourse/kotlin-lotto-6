package lotto

class Lotto(
    private val numbers: List<Int>,
    private val winnigNumber: List<Int>,
    private val bonusNumber: Int
) {

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 총 6개여야 합니다." }
    }

    fun winningJudge(): Int {
        var numberOfSameNumber = 0
        for (i in numbers) {
            if (i in winnigNumber) {
                numberOfSameNumber++
            }
        }
        // n개 일치하면 n을 리턴. 만약 5개 일치하면 보너스 있는지 확인하고 있으면 0리턴, 없으면 5 리턴
        if (numberOfSameNumber != 5) {
            return numberOfSameNumber
        }
        if (bonusNumber in numbers) {
            return -1
        }
        return numberOfSameNumber
    }

}
