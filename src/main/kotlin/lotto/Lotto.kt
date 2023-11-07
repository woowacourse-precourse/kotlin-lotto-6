package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        val testing_copy = numbers.distinct()
        require(testing_copy.size == 6)
        println(numbers)
    }

    public fun round(win_num: List<Int>, bonus: Int): Int {
        val count = winningCheck(win_num)

        if (count == 5 && numbers.contains(bonus)){
            return 2
        }

        when (count) {
            3 -> return 5
            4 -> return 4
            5 -> return 3
            6 -> return 1
        }
    }

    private fun winningCheck(win_num: List<Int>): Int {
        var count: Int = 0
        for (i in 0..win_num.size - 1) {
            if (numbers.contains(win_num[i])) {
                count++
            }
        }
        return count
    }


}
