package lotto

class InputValidator {
    companion object {
        fun readNumbers(inputMessage: String): List<Int> {
            print(inputMessage)
            try {
                val numbers = readLine()!!.split(",").map { it.trim().toInt() }
                if (numbers.size != 7) {
                    throw IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호를 모두 입력하세요.")
                }
                val lottoNumbers = numbers.subList(0, 6)
                val bonusNumber = numbers[6]
                if (lottoNumbers.toSet().size != 6 || lottoNumbers.any { it !in 1..45 } || bonusNumber !in 1..45) {
                    throw IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
                }
                return numbers
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.")
            }
        }
    }
}