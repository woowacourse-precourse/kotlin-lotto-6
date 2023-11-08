package lotto.validator

class Validator {
    fun validatedNumberInRange(num: Int, start: Int, end: Int): Int {
        if (num !in start..end) throw IllegalArgumentException("[ERROR] 로또 번호는 ${start}부터 ${end}사이 숫자여야 합니다.")
        return num
    }
}