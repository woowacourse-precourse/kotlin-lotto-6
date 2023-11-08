package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.distinct().size == 6)
    }
    fun getLotto(): List<Int> {
        return numbers
    }

    fun getRank(winningNums: List<Int>, bonusNum: Int): Rank {
        val set1 = numbers.toMutableSet()
        val set2 = winningNums.toMutableSet()
        set1.retainAll(set2)
        val winnings = set1.size
        val bonus = bonusNum in numbers
        val rank = when(winnings){
            3 -> Rank.rank5
            4 -> Rank.rank4
            5 -> if(bonus) Rank.rank3 else Rank.rank2
            6 -> Rank.rank1
            else -> Rank.rank0
        }
        return rank
    }
}
enum class Rank {
    rank0, rank5, rank4, rank3, rank2, rank1
}