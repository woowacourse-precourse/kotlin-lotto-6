package lotto

fun isUniqueWithBonusNumber(numbers: List<Int>, bonusNumber: Int): Boolean {
    val uniqueNumbers: HashSet<Int> = hashSetOf(bonusNumber)
    return numbers.all { uniqueNumbers.add(it) }
}

fun validateWinningNumber(winningNumber: Pair<List<Int>, Int>) {
    val (numbers, bonusNumber) = winningNumber
    require(hasSixNumbers(numbers)) { ErrorMessages.NORMAL_NUMBER_COUNT_SHOULD_BE_SIX }
    require(isUnique(numbers)) { ErrorMessages.NORMAL_NUMBER_SHOULD_BE_UNIQUE }
    require(areAllNumbersInValidRange(numbers)) { ErrorMessages.NORMAL_NUMBER_SHOULD_BE_IN_RANGE }
    require(isNumberInValidRange(bonusNumber)) { ErrorMessages.BONUS_NUMBER_SHOULD_BE_IN_RANGE }
    require(isUniqueWithBonusNumber(numbers, bonusNumber)) { ErrorMessages.BONUS_NUMBER_SHOULD_BE_UNIQUE }
}