package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class LottoPick {

    fun randomNumber(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }
    fun randomLotto(cnt: Int):MutableList<List<Int>>{
        val lottoList: MutableList<List<Int>> = mutableListOf()
        for(i in 0 until cnt){
            val numbers = randomNumber()
            lottoList.add(numbers)
            LottoView().numbersList(numbers)
        }
        return lottoList
    }

    fun pickValid(pickList: List<String>){
        if(pickList.size != 6){
            throw IllegalArgumentException("[Error] 입력 값이 6개가 되어야 합니다.")
        }
        for(numberString in pickList){
            val number = numberString.toIntOrNull()
            if(number == null){
                throw IllegalArgumentException("[Error] 잘못된 입력 값")
            }
        }
    }

    fun pickNumber(): List<String> {
        var pickList: List<String>? = null
        while(pickList == null) {
            LottoView().pickView()
            val numbers = Console.readLine()
            var pickList = numbers.split(",")
            try {
                pickValid(pickList)
                return pickList
            } catch (e: IllegalArgumentException) {
                println(e.message)
                pickList = emptyList()
            }
        }
        return pickList
    }
}