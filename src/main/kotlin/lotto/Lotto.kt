package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(hasSixNumbers(numbers)){""}
        require(isInValidRange(numbers)){""}
        require(isUnique(numbers)){""}
    }

    override fun toString():String{
        return numbers.toString()
    }
    // TODO: 추가 기능 구현
}
