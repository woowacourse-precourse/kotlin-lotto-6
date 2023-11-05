package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        // 겹치지 않는 번호인가?
        require(numbers.toSet().size == 6)
        // 번호들이 1에서 45까지의 사이인가?
        numbers.map { number ->
            require(number in 1..45)
        }
    }

    val numberList: List<Int> = this.numbers

}
