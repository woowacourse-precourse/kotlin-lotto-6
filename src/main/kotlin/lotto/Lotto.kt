package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == 6) { "로또 번호는 중복될 수 없습니다." }
    }

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun match(winningNumbers: Lotto, bonusNumber: Int): Rank {
        val matchCount = numbers.intersect(winningNumbers.numbers).size
        val matchBonus = numbers.contains(bonusNumber)
        return Rank.valueOf(matchCount, matchBonus)
    }

    override fun toString(): String = numbers.sorted().toString()

}