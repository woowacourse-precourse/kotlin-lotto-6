package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        for(check_num in 0..5){
            require(numbers.get(check_num) >= 1 && numbers.get(check_num) <= 45)
        }
    }

    fun getTicketNumber() : List<Int>{
        return numbers
    }

    // TODO: 추가 기능 구현
}
