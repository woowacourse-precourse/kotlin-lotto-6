package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun validatePriceAmount(): String {
        println("구입금액을 입력해 주세요.")
        val priceAmount = Console.readLine()
        if (priceAmount.isEmpty()) {
            throw IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.")
        }
        println()
        return priceAmount
    }

    fun validatePriceInt(priceAmount: String): Int {
        return priceAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 정수를 입력해주세요.")
    }

    fun validatePriceRange(priceAmount: Int): Int {
        if (priceAmount < 1000) {
            throw IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해주세요.")
        }
        return priceAmount
    }

    fun validatePriceUnit(priceAmount: Int): Int {
        if (priceAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
        }
        return priceAmount
    }

    fun calculateCount(priceAmount: Int): Int {
        println("${priceAmount / 1000}개를 구매했습니다.")
        return priceAmount / 1000
    }

    fun validateLottoNumberInput(): String {
        println("당첨 번호를 입력해 주세요.")
        val lottoNumber = Console.readLine()
        if (lottoNumber.isEmpty()) {
            throw IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.")
        }
        println()
        return lottoNumber
    }

    fun validateLottoNumber(lottoNumbers: String): List<String> {
        val numberList = lottoNumbers.split(',').map { it.trim() }
        for (element in numberList) {
            if (element.toIntOrNull() == null) {
                throw IllegalArgumentException("[ERROR] 정수를 입력해주세요.")
            }
        }
        return numberList
    }

    fun validateLottoSize(lottoNumbers: List<String>) {
        if (lottoNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.")
        }
    }

    fun validateLottoRange(lottoNumbers: List<String>): List<Int> {
        val intLottoNumbers = mutableListOf<Int>()
        for (element in lottoNumbers) {
            val currentNumber = element.toInt()
            if (currentNumber !in 1..45) {
                throw IllegalArgumentException("[ERROR] 1에서 45사이의 정수를 입력해주세요.")
            }
            intLottoNumbers.add(currentNumber)
        }
        return intLottoNumbers
    }

    fun validateLottoRepeat(lottoNumbers: List<Int>) {
        val set = HashSet<Int>()
        for (element in lottoNumbers) {
            if (!set.add(element)) {
                throw IllegalArgumentException("[ERROR] 중복되지 않은 로또 번호를 입력해주세요.")
            }
        }
    }

    fun validateBonusNumberInput(): String {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()
        if (bonusNumber.isEmpty()) {
            throw IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.")
        }
        println()
        return bonusNumber
    }

    fun validateBonusNumber(inputNumber: String): Int {
        return inputNumber.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 정수를 입력해주세요.")
    }

    fun validateBonusNumberRange(inputNumber: Int) {
        if (inputNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] 1에서 45사이의 정수를 입력해주세요. ")
        }
    }

    fun validateBonusRepeat(inputNumber: Int, lottoNumbers: List<Int>) {
        if (inputNumber in lottoNumbers) {
            throw IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않은 수를 입력해주세요.")
        }
    }
}