package lotto

class Lotto(private val numbers: List<Any>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
}
