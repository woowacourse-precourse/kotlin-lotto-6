package lotto

import camp.nextstep.edu.missionutils.Console

const val ONE_LOTTO_PRICE = 1000

class InputManager {
    private lateinit var winningNumber: List<String>
    private var inputMoney: Int = ONE_LOTTO_PRICE
    private var bonusNumber: Int = 1

    fun playerInsertMoney() : Int{
        setInputMoney()
        return inputMoney
    }
    fun playerInputNumbers() {
        setWinningNumber()
        setBonusNumber()
    }
    private fun setInputMoney() {
        println("구입금액을 입력해 주세요.")
        while(true) {
            try {
                inputMoney = Console.readLine().toInt()
                checkInputNumberRange()
                break
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
                println("다시 입력해주세요.")
            }
        }
    }

    fun getWinningNumber() = winningNumber
    private fun setWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
        while(true) {
            try {
                winningNumber = Console.readLine().split(",").toList()
                checkWinningNumberRange()
                break
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
                println("다시 입력해주세요.")
            }
        }
    }

    private fun setBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
        while(true) {
            try {
                bonusNumber = Console.readLine().toInt()
                checkBonusNumberRange()
                break
            }
            catch (e: IllegalArgumentException) {
                println(e.message)
                println("다시 입력해주세요.")
            }
        }
    }
    private fun checkInputNumberRange() {
        if(inputMoney % ONE_LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위에 맞춰서 넣어주세요.")
        }
    }
    private fun checkWinningNumberRange() {
        if(winningNumber.size != 6) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.")
        }
        if (winningNumber.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] 중복되는 수는 넣을 수 없습니다.")
        }
        for(i in winningNumber.indices) {
            if(winningNumber[i].toInt() !in 1..45) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    private fun checkBonusNumberRange() {
        if(bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자입니다.")
        }
    }
}