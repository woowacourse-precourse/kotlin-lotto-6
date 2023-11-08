package lotto

class LottoProgramError {
    fun checkInputMoneyDivided1000Won(money: Int) {
        if (money % 1000 != 0) throw IllegalArgumentException()
    }

    fun checkNumberCountIsSix(numbers: List<Int>) {
        if (numbers.size != 6) throw IllegalArgumentException()
    }

    fun checkNumberIsRandom(numbers: List<Int>) {
        var numbersRandom = numbers.toSet()
        if (numbers.size != numbersRandom.size) throw IllegalArgumentException()
    }

    fun checkNumberRange(numbers: List<Int>) {
        numbers.forEach {
            if (it > 45 || it < 1) throw IllegalArgumentException()
        }
    }

    fun checkBonusNumberRange(bonusNumber: Int) {
        if (bonusNumber > 45 || bonusNumber < 1) throw IllegalArgumentException()
    }
}