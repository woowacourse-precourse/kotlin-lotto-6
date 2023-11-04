package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(
            numbers.distinct()
                .size == 6
        )
    }
}
