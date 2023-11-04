package lotto.validate

class ValidateSplit {
    fun validateSplitMyNumbers(myNumbers: List<String>): List<String> {
        myNumbers.forEach {
            validateInputZero(it)
        }
        return myNumbers
    }

    private fun validateInputZero(myNumbers: String) {
        require(myNumbers.toInt() != 0) { "0은 입력될 수 없습니다." }
    }



}