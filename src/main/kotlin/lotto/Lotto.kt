package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == numbers.size)
    }

    fun amount(): List<Int> {
        return numbers.sorted()
    }

    fun checkInNumber(number: Int, Numbers: List<Int>): Boolean {
        for (num in Numbers) {
            if (num == number) {
                return true
            }
        }
        return false
    }

    fun checkSameNum(winningNumbers: List<Int>): Int {
        var sameCount = 0
        for (number in numbers) {
            if (checkInNumber(number, winningNumbers)) {
                sameCount++
            }
        }
        return sameCount
    }

    fun checkWin(winningNumbers: List<Int>, plusNumber: Int): Int {
        when (checkSameNum(winningNumbers)) {
            0 -> return 0
            1 -> return 0
            2 -> return 0
            3 -> return 5
            4 -> return 4
            5 -> if (checkInNumber(plusNumber, numbers)) {
                return 2
            } else if (!checkInNumber(plusNumber, numbers)) {
                return 3
            }

            6 -> return 1
        }
        return 0
    }
}
