package lotto.domain


class LottoCompare(private val numbers: MutableList<Lotto>) {
    fun compare(winning: List<Int>): MutableList<Int> {
        var winningCount: MutableList<Int> = mutableListOf()
        for (index in numbers.indices) {
            winningCount.add(compareR(winning, numbers[index]))
        }
        return winningCount
    }

//    fun compareBonus(bonus: Int, lotto: MutableList<List<Int>>) {
//        for (index in lotto.indices) {
//            compareRBonus(bonus, lotto[index])
//        }
//    }

    private fun compareR(winning: List<Int>, i: Lotto): Int {
        val intersectNumber: Set<Int> = i.intersect(winning)
        return intersectNumber.size
    }

//    private fun compareRBonus(bonus: Int, i: List<Int>) {
//        if (i.contains(bonus)) {
//            // 포함하면 안되기 때문에 예외 발생
//        }
//    }
}