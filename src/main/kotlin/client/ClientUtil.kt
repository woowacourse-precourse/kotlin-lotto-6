package client

import exception.Exception

class ClientUtil {
    private val exception = Exception()
    private val isIntRegex = Regex("\\d+\$")

    fun checkIsInteger(input: String) {
        if (!isIntRegex.matches(input)) {
            exception.noInteger()
        }
    }

    fun checkNoDividedByThousand(money: Int) {
        if (money % 1000 != 0) {
            exception.noDividedThousand()
        }
    }

    fun checkIsCorrectWinNumber(input: String) {
        val regex = Regex("^(\\d+),(\\d+),(\\d+),(\\d+),(\\d+),(\\d+)")
        if (!regex.matches(input)) {
            exception.noCorrectWinNumber()
        }
    }

    fun checkIsCorrectLottoNumber(input: Int) {
        if (input !in 1..45) {
            exception.noCorrectLottoNumber()
        }
    }

    fun checkIsDuplicated(stringInputList: List<String>) {
        if(stringInputList.size != stringInputList.distinct().size){
            exception.duplicatedWinPrizeList()
        }
    }

    fun checkIsInWinNumberList(bonusNumber: Int, winNumberList: List<Int>) {
        if(bonusNumber in winNumberList){
            exception.bonusInWinNumberList()
        }
    }
}