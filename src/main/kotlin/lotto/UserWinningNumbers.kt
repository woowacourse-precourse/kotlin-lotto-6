package lotto

data class UserWinningNumbers(
    val userPickNumbers: List<Int>,
    val bonusNumber: Int
) {

    init {
        require(userPickNumbers.size == 6) { Message.ERROR_USER_PICK_NUMBERS_SIX_RANGE }
        requireUserPickNumberDuplicateLottoNumber()
        requireUserPickNumberValidRange()
        requireDuplicateBonusNumber()
        requireBonusNumberValidRange()
    }

    private fun requireDuplicateBonusNumber() {
        val uniqueNumbers = HashSet<Int>()
        for (number in userPickNumbers) {
            require(uniqueNumbers.add(number)) { Message.ERROR_USER_PICK_NUMBERS_DUPLICATION }
        }
        require(uniqueNumbers.add(bonusNumber)) { Message.ERROR_BONUS_NUMBER_DUPLICATION }
    }

    private fun requireUserPickNumberDuplicateLottoNumber() {
        val uniqueNumbers = HashSet<Int>()
        for (number in userPickNumbers) {
            require(uniqueNumbers.add(number)) { Message.ERROR_USER_PICK_NUMBERS_DUPLICATION }
        }
    }

    private fun requireUserPickNumberValidRange() {
        for (number in userPickNumbers) {
            require(number in VALID_RANGE) { Message.ERROR_VALID_RANGE }
        }
    }

    private fun requireBonusNumberValidRange() {
        require(bonusNumber in VALID_RANGE) { Message.ERROR_VALID_RANGE }
    }

    companion object {
        val VALID_RANGE = 1..45
    }

}

