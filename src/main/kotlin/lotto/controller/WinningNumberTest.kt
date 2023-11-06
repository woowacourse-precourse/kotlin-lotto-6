package lotto.controller

class WinningNumberTest (private val numbers: List<String>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        for(check_num in 0..5){
            require(numbers.get(check_num).toInt() >= 1 && numbers.get(check_num).toInt() <= 45)
        }
    }

    fun getWinningNumber() : List<String>{
        return numbers
    }
}