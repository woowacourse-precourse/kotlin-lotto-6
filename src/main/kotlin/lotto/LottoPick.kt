package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class LottoPick() {

    private fun randomNumber(): List<Int> {
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

    fun pickValid(pickList: List<String>): List<Int>{
        val numbers = pickList.mapNotNull { it.toIntOrNull() }
        Lotto(numbers)
        return numbers
    }
    private fun validPickNumber(): List<Int> {
        LottoView().pickView()
        val numbers = Console.readLine()
        val pickList = numbers.split(",")
        return pickValid(pickList)
    }
    fun pickNumber(): List<Int> {
        while(true) {
            try {
                return validPickNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    fun bonusCheck(bonus: String){
        val bonusNum = bonus.toIntOrNull()
        if(bonusNum == null || bonusNum < 0 || bonusNum > 45)
            throw IllegalArgumentException("[Error] 보너스 번호가 유효하지 않습니다.")
    }
    fun bonusRepeat(bonusNumber: Int, prizeNumber: List<Int>){
        if(bonusNumber in prizeNumber)
            throw IllegalArgumentException("[Error] 보너스 번호가 당첨 번호에 중복됩니다.")
    }
    fun bonusPickNumber(prizeNumber:List<Int>): Int {
        while (true) {
            try {
                LottoView().bonusView()
                val bonusNumber = Console.readLine()
                bonusCheck(bonusNumber)
                bonusRepeat(bonusNumber.toInt(), prizeNumber)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}