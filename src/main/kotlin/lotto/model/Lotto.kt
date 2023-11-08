package lotto.model

import lotto.config.GameConfig.END_NUMBER
import lotto.config.GameConfig.START_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] 로또 번호는 6개의 숫자를 가집니다."
        }
        require(numbers.size == numbers.distinct().size) {
            "[ERROR] 로또 번호는 중복되면 안 됩니다."
        }
        numbers.forEach {
            require(it in START_NUMBER..END_NUMBER) {
                "[ERROR] 로또 번호는 1 ~ 45 이어야 합니다."
            }
        }
    }

    // TODO: 추가 기능 구현
    fun calculateMatchingCount(inputNumbers: Set<Int>): Int = numbers.count { it in inputNumbers }

    fun containBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    fun calculateLottoRank(matchingNumberCount: Int, bonusNumberMatch: Boolean): WinningRank {
        val conditions = listOf(
            (matchingNumberCount == 6) to WinningRank.FIRST,
            (matchingNumberCount == 5 && bonusNumberMatch) to WinningRank.SECOND,
            (matchingNumberCount == 5) to WinningRank.THIRD,
            (matchingNumberCount == 4) to WinningRank.FOURTH,
            (matchingNumberCount == 3) to WinningRank.FIFTH
        )

        return conditions.firstOrNull { it.first }?.second ?: WinningRank.FAILURE
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
