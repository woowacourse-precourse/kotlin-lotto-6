package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] 로또 번호는 6개의 숫자를 가집니다."
        }
        require(numbers.size == numbers.distinct().size) {
            "[ERROR] 로또 번호는 중복되면 안 됩니다."
        }
        numbers.forEach {
            require(it in 1..45) {
                "[ERROR] 로또 번호는 1 ~ 45 이어야 합니다."
            }
        }
    }

    // TODO: 추가 기능 구현
    fun calculateMatchingCount(inputNumbers: Set<Int>): Int = numbers.count { it in inputNumbers }

    fun containBonusNumber(bonusNumber: Int): Boolean = true

    fun calculateLottoRank(matchingNumberCount: Int, bonusNumberMatch: Boolean): WinningRank = WinningRank.FAILURE

}
