package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        val uniqueNumbers = HashSet<Int>()
        for (number in numbers) {
            require(number in 1..45) { "로또 번호는 1부터 45 사이의 숫자여야 합니다." }
            require(uniqueNumbers.add(number)) { "로또 번호에 중복된 숫자가 있습니다." }
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
