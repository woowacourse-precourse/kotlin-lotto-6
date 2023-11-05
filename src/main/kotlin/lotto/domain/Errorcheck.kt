package lotto.domain

fun blankCheck(input: String) {
    if (input.isBlank()) {
        throw IllegalArgumentException("공백은 안됩니다")
    }
}

fun numberCheck(input: String) {
    if (input.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자가 아닌값이 있습니다")
    }
}

fun moneyCheck(money: Int) {
    if (money % 1000 != 0) {
        throw IllegalArgumentException("1000으로 나누어떨어져야합니다")
    }
}

fun winningNumberErrorCheck(input: String, splitInput: List<String>): List<Int> {
    winBlankCheck(splitInput)
    winNumberCheck(splitInput)
    winNumberIndexCheck(splitInput)
    val changeNumbers = input.split(",").map { it.toInt() }
    winChangeNumberCheck(changeNumbers)
    winValidNumberCheck(changeNumbers)
    return changeNumbers.filter { it in 1..45 }
}

fun winNumberCheck(splitInput: List<String>) {
    splitInput.forEach {
        runCatching { it.toInt() }
            .onFailure { throw IllegalArgumentException("숫자가 아닌") }
    }
}

fun winBlankCheck(splitInput: List<String>) {
    for(i in splitInput){
        if(i==""){
            throw IllegalArgumentException("공백 노")
        }
    }
}

fun winNumberIndexCheck(splitInput: List<String>) {
    if (splitInput.size != 6) {
        throw IllegalArgumentException("입력 값은 6개여야 합니다")
    }
}

fun winValidNumberCheck(changeNumbers: List<Int>) {
    val validNumber= changeNumbers.filter { it in 1..45 }
    if (validNumber.size != 6) {
        throw IllegalArgumentException("범위를 초과한 수가 있습니다")

    }
}

fun winChangeNumberCheck(changeNumbers: List<Int>) {
    if (changeNumbers.distinct().size != changeNumbers.size) {
        throw IllegalArgumentException("중복된 값이 있습니다. 다시 입력하세요.")
    }
}


fun bonusNumberErrorCheck(winningNumber: List<Int>, bonus: String): Int {
    bonusBlankCheck(bonus)
    bonusNumberCheck(bonus)
    val bonusNumber = bonus.toInt()
    bonusRangeCheck(bonusNumber)
    bonusWinningDuplicateCheck(winningNumber, bonusNumber)
    return bonusNumber
}

fun bonusBlankCheck(bonus: String) {
    if (bonus.equals("")) {
        throw IllegalArgumentException("공백은 안됩니다")
    }
}

fun bonusRangeCheck(bonusNumber: Int) {
    if (bonusNumber < 1 || bonusNumber > 45) {
        throw IllegalArgumentException("범위를 초과한 수가 있습니다")
    }
}

fun bonusWinningDuplicateCheck(winningNumber: List<Int>, bonusNumber: Int) {
    if (bonusNumber in winningNumber) {
        throw IllegalArgumentException("이미 당첨번호에 있습니다.")
    }
}

fun bonusNumberCheck(bonus: String){
    if(bonus.toIntOrNull()==null){
        throw IllegalArgumentException("숫자가 아님")
    }
}
