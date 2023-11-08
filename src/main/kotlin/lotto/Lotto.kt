package lotto

import camp.nextstep.edu.missionutils.Console


class Lotto(private val numbers: MutableList<Int>) {
    init {
        require(numbers.size == 6)
    }
    private fun getInput(): String {
        return Console.readLine()
    }

    fun getBonusNumber(){
        var bonusNumber: Int
        while (true) {
            println("\n보너스 번호를 입력해 주세요.")
            try {
                bonusNumber = getInput().toInt()
                checkBonusNumberValid(bonusNumber)
                println(bonusNumber)
                break
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자는 하나만 써주세요!!")
            } catch (e: IllegalArgumentException) {
                catchErrorMessageInGetBonusNumber(e)
            }
        }
    }

    private fun catchErrorMessageInGetBonusNumber(e: IllegalArgumentException) {
        when (e.message) {
            "중복 숫자 오류" -> println("[ERROR] 보너스가 중복입니다")
            "입력 범위 오류" -> println("[ERROR] 1 ~ 45 사이에 숫자만 써주세요")
        }
    }

    private fun checkBonusNumberValid(bonusNumber: Int) {
        checkLength(bonusNumber)
        checkBonusDuplicate(bonusNumber)
        numbers.add(bonusNumber)
    }

    private fun checkBonusDuplicate(bonusNumber: Int) {
        if (numbers.contains(bonusNumber)) {
            throw IllegalArgumentException("중복 숫자 오류")
        }
    }
    private fun checkLength(checkLengthNumber: Int) {
        if (checkLengthNumber !in 1..45) {
            throw IllegalArgumentException("입력 범위 오류")
        }
    }

    fun printLottoNumbers() {
        println(numbers)
    }

}
