package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class BonusErrorCode(val message: String) {
    BONUS_NOT_VALID("[ERROR] 보너스 번호가 유효하지 않습니다."),
    BONUS_REPEATED("[ERROR] 보너스 번호가 당첨 번호와 겹치는 번호입니다.")
}
class LottoPick() {

    private fun randomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
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
        val numbers = Console.readLine()
        val pickList = numbers.split(",")
        return pickValid(pickList)
    }
    fun pickNumber(): List<Int> {
        LottoView().pickView()
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
            throw IllegalArgumentException(BonusErrorCode.BONUS_NOT_VALID.message)
    }
    fun bonusRepeat(bonusNumber: Int, prizeNumber: List<Int>){
        if(bonusNumber in prizeNumber)
            throw IllegalArgumentException(BonusErrorCode.BONUS_REPEATED.message)
    }
    fun bonusPickNumber(prizeNumber:List<Int>): Int {
        LottoView().bonusView()
        while (true) {
            try {
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