package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 6개의 숫자만 입력해 주세요." }
        require(numbers.distinct().size == 6) { "[ERROR] 중복 되지 않는 숫자를 입력해 주세요." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 1에서 45사이의 숫자를 입력해 주세요." }
    }

    fun getDelimiter(): String {
        return numbers.joinToString(",")
    }
    fun checkLotto(winning: WinningNumbers): String {
        var count = 0
        var bonus = false
        for (num in numbers) {
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