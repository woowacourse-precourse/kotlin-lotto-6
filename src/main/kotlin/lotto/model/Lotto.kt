package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(isAllUnique(this.numbers))
        require(isSorted(this.numbers))
    }

    private fun isSorted(numbers: List<Int>): Boolean {
        return numbers == numbers.sorted()
    }

    private fun isAllUnique(numbers: List<Int>): Boolean {
        return numbers.size == numbers.toSet().size
    }

    override fun toString(): String {
        val nums = numbers.joinToString(", ")
        return "[$nums]"
    }

    private fun getMatchCount(winningLottoInfo: Lotto, bonusInfo: Int): Int{
        var count = 0
        for (i in this.numbers){
            if (winningLottoInfo.numbers.contains(i)){
                count++
            }
        }

        when(count){
            3 -> return 5
            4 -> return 4
            5 -> {
                if (!isBonusInLotto(this.numbers, bonusInfo)) return 3
                return 2
            }
            6 -> return 1
        }
        return 0
    }

    private fun isBonusInLotto(numbers: List<Int>, bonusInfo: Int): Boolean {
        return numbers.contains(bonusInfo)
    }

    fun getRanks(winningLottoInfo: Lotto, bonusInfo: Int): Int {
        val rank = getMatchCount(winningLottoInfo, bonusInfo)
        return rank
    }
}
