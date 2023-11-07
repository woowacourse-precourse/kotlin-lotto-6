package lotto


class WinningNumbers(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] 6개의 숫자만 입력해 주세요." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] 중복 되지 않는 숫자를 입력해 주세요." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] 1에서 45사이의 숫자를 입력해 주세요." }
        require(bonusNumber !in winningNumbers) { "[ERROR] 중복 되지 않는 숫자를 입력해 주세요." }
        require(bonusNumber in 1..45) { "[ERROR] 1에서 45사이의 숫자를 입력해 주세요." }
    }

    fun numbers(): List<Int> {
        return winningNumbers
    }

    fun bonus(): Int {
        return bonusNumber
    }
    fun checkLotto(winning: WinningNumbers): String {
        var count = 0
        var bonus = false
        for (num in numbers()) {
            if (num in winning.numbers()) {
                count += 1
            }
            if (num == winning.bonus()) {
                bonus = true
            }
        }
        return Reward.getRank(count, bonus)
    }
}



