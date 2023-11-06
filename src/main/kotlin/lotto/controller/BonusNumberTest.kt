package lotto.controller

class BonusNumberTest (private val winning_number: List<String>,private val number : Int) {

    init{
        require(number >= 1 && number <= 45)
        for(check_num in 0..winning_number.size-1){
            require(!winning_number.contains(number.toString()))
        }
    }

    fun getBonusNumber() : Int{
        return number
    }

}