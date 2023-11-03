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

//enum class