package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.distinct().size == 6)
        println(numbers)
    }

    fun win_checker(win_num:MutableList<Int>, bonus:Int): Int{
        var equal:Int = 0
        var bonus_value:Int = 0
        for (i in numbers){ if (i in win_num){equal ++} }
        if (bonus in numbers){bonus_value += 10}
        when (equal){
            3 -> return 0
            4 -> return 1
            5 -> return 2
            105 -> return 3
            6 -> return 4
        }
        return 5
    }
}

enum class Error(val message: String){
    error_moneyinput("[ERROR] 돈은 1000원 단위로 입력해주세요 Ex) 1000, 85000"),
    error_numberinput("[ERROR] 1에서 45까지의 숫자를 중복없이 6개 입력해주세요 Ex) 1,2,3,4,5,6"),
    error_bonusinput("[ERROR] 1에서 45까지의 숫자를 당첨번호와 중복없이 입력해주세요 Ex) 7")
}