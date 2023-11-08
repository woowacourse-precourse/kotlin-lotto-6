package lotto

class LottoProgramError {
    fun checkInputMoneyDivided1000Won(money: Int) {
        if (money % 1000 != 0) throw IllegalArgumentException(Error.INPUTMONEYDIVIDED1000WON.output)
    }

    fun checkIsNumber(number: String) {
        if (number == null || number.length == 0) {
            throw IllegalArgumentException(Error.ISNUMBER.output)
        }
        for (c in number)
        {
            if (c < '0' || c > '9') {
                throw IllegalArgumentException(Error.ISNUMBER.output)
            }
        }
    }

    fun checkNumberCountIsSix(numbers: List<Int>) {
        if (numbers.size != 6) throw IllegalArgumentException(Error.NUMBERCOUNTISSIX.output)
    }

    fun checkNumberIsRandom(numbers: List<Int>) {
        var numbersRandom = numbers.toSet()
        if (numbers.size != numbersRandom.size) throw IllegalArgumentException(Error.NUMBERISRANDOM.output)
    }

    fun checkNumberRange(numbers: List<Int>) {
        numbers.forEach {
            if (it > 45 || it < 1) throw IllegalArgumentException(Error.NUMBERRANGE.output)
        }
    }

    fun checkBonusNumberRange(bonusNumber: Int) {
        if (bonusNumber > 45 || bonusNumber < 1) throw IllegalArgumentException(Error.BONUSNUMBERRANGE.output)
    }
}