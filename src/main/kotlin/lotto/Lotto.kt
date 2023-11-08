package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == numbers.size)
    }

    fun compareNumber(nums: List<Int>): Int {
        val myNumbers = numbers.toSet()
        val winNumbers = nums.toSet()
        val intersection = myNumbers.intersect(winNumbers)

        return intersection.size
    }

    fun compareBonusNumber(number: Int): Boolean {
        return numbers.contains(number)
    }
}
