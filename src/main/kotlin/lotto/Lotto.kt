package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == GameConst.NUM_COUNT)
        require(numbers.distinct().size == numbers.size)
        require(numbers.all {
            it in 1..GameConst.MAX_NUM
        })
    }

    // TODO: 추가 기능 구현
}
