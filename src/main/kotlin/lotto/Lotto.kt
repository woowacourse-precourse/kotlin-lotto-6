package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(
            numbers.distinct()
                .size == 6
        )
        require(numbers.all { it in 1..45 })
    }

    internal fun getAscendingList() = numbers.sorted()
}
