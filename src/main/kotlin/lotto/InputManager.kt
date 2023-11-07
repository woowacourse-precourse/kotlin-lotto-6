package lotto

import camp.nextstep.edu.missionutils.Console

const val ONE_LOTTO_PRICE = 1000

class InputManager {
    private lateinit var winningNumber: List<String>
    private var inputMoney: Int = 1000
    private var bonusNumber: Int = 1

    fun playerInsertMoney() : Int{
        setInputMoney()
        return inputMoney
    }
    fun playerInputnumbers() {
        setWinningNumber()
        setBonusNumber()
    }
    fun setInputMoney() {
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
    fun setWinningNumber() {
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

    fun setBonusNumber() {
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
    fun checkInputNumberRange() {
        if(inputMoney % ONE_LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위에 맞춰서 넣어주세요.")
        }
    }
    fun checkWinningNumberRange() {
        if(winningNumber.size != 6) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.")
        }
        for(i in winningNumber.indices) {
            if(inputMoney !in 1..45) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun checkBonusNumberRange() {
        if(bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자입니다.")
        }
    }
}