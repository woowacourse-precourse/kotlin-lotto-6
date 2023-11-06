package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현

    fun compareNumber(nums: List<Int>): Int {

        val myNumbers = numbers.toSet()
        val winNumbers = nums.toSet()

        val intersection = myNumbers.intersect(winNumbers)
        return intersection.size
    }
}
