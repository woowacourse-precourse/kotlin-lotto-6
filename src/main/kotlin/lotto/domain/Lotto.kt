package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_LENGTH)
    }

    fun showLotto() = numbers.addCommaAndBracket()

    fun compareToBonus(bonus: Int): Boolean = numbers.contains(bonus)

    fun comparetoTarget(target: List<Int>): Int {
        var count = 0

        for (number in numbers) {
            if (number in target) {
                count++
            }
        }
        return count
    }
    private fun List<Int>.addCommaAndBracket(): String {
        val formatIssuedLotto = this.joinToString(",") { it.toString() }
        return "[$formatIssuedLotto]"
    }


    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_LENGTH = 6
        const val SINGLE_LOTTO_PRICE = 1000

    }
}
