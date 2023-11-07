package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        val testing_copy = numbers.distinct()
        require(testing_copy.size == 6)
    }

    public fun roundStart(bonus: Int, count: Int) {

    }

    private fun winningCheck(user_num: List<Int>): Int {
        var count: Int = 0
        for (i in 1..user_num.size) {
            if (numbers.contains(user_num[i])) {
                count++
            }
        }
        return count
    }


}
