package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        val testing_copy = numbers.distinct()
        require(testing_copy.size == 6)
    }

    public fun roundStart(bonus: Int, count: Int) {
        for (i in 1..count) {
            val user_num = NumberGenerator().numberGenerate()
            println(user_num)
            val rank = winningCheck(user_num)
        }
    }

    private fun winningCheck(user_num: List<Int>): Int {
        var count: Int = 0
        for (i in 0..user_num.size - 1) {
            if (numbers.contains(user_num[i])) {
                count++
            }
        }
        return count
    }


}
