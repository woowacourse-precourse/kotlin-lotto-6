package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        //todo 서로다른 숫자 인지, 1~45까지의 숫자인지 체크필요
    }

    fun getNumbers() = numbers
}
