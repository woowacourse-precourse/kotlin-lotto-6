package lotto

class Validator {
    fun validatePurchaseMoney(purchaseMoney: String): Boolean {
        return try {
            isNumberOverZero(purchaseMoney) && isDividedUpThousand(purchaseMoney.toInt())
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e}")
            false
        }
    }

    fun isNumberOverZero(input: String): Boolean {
        val number = input.toIntOrNull()
        return if (number != null && number > 0) {
            true
        } else {
            throw IllegalArgumentException("0보다 큰 정수를 입력해주세요.")
        }
    }

    fun isDividedUpThousand(money: Int): Boolean {
        return if (money % 1000 == 0) {
            true
        } else {
            throw IllegalArgumentException("구입 금액이 1000원으로 나누어 떨어지지 않습니다.")
        }
    }

    fun validateLottoNumber(lotto: String): Boolean {
        return try {
            containsComma(lotto)
            val lottoNumbers: List<String> = lotto.split(",")
            for (number in lottoNumbers) {
                isNumberOverZero(number)
            }
            true
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e}")
            false
        }
    }

    fun containsComma(lotto: String): Boolean {
        return if (lotto.contains(',')) {
            true
        } else {
            throw IllegalArgumentException("로또 번호는 쉼표(,)로 구분지어주세요.")
        }
    }
}