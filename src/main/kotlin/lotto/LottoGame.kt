package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class LottoGame {

    // 작성순서 : 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체
    init {
        println("[로또 게임]")
        println("====================")
    }

    /*enum class E_Class {

    }*/

    companion object {
        const val buyPrice = "구입금액"
        const val chosenNumber = "당첨번호"
        const val bonusNumber = "보너스번호"

        val zeroStartPattern = Regex("^0{1,}[0-9]{1,}")
        val numberPattern = Regex("\\d")
        val numberAndCommaPattern = Regex("[0-9,]")

        var inputResult = ""
        var errorCheck = false

        const val caseCommon = 0

        //입력 유형 중 공통 체크하는 유형
        const val case1 = 1
        const val case2 = 2

        private const val errorMessageVacant = "[ERROR] 비어있거나 입력하지 않으셨습니다."

        private const val errorMessageZeroAndMinus = "[ERROR] 0 또는 음수를 입력하셨습니다."
        private const val errorMessageOnlyNumber = "[ERROR] 숫자만 입력할 수 있습니다."
        private const val errorMessageZeroStart = "[ERROR] 0으로 시작하는 숫자를 입력하셨습니다."
        private const val errorMessageOneToFortyfive = "[ERROR] 숫자범위를 벗어났습니다. (범위 : 1 ~ 45)"
        private const val errorMessageThousand = "[ERROR] 1000 단위 숫자가 아닙니다"
        private const val errorMessageMaxHundredThousand =
            "[ERROR] 숫자범위를 벗어났습니다. (범위 : 1000 ~ 100000)"

        private const val errorMessageNumberAndComma = "[ERROR] 숫자와 쉼표만 입력할 수 있습니다."
        private const val errorMessageNotComma = "[ERROR] 쉼표가 입력되지 않았습니다."


        fun requestMessage(keyword: String) {
            when (keyword) {
                "구입금액" -> println("${keyword}을 숫자만 입력해주세요 (1000 단위, 최대 10만)")
                "당첨번호", "보너스번호" -> println("${keyword}를 입력해주세요")
            }

        }

        fun userInput(): String {
            inputResult = Console.readLine()
            return inputResult
        }

        fun buyMessage(buyNumber: Int) {
            println("${buyNumber} 게임을 구매했습니다")
        }

        fun lottoSelectBall(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }

        fun inputCheck(result: String): Boolean {
            errorCheck = checkVacant(result)
            if (!errorCheck) {
                errorCheck = checkStartZero(result)
            }
            if (!errorCheck) {
                errorCheck = checkOnlyNumber(result)
            }
            if (!errorCheck) {
                errorCheck = checkMinusOrZero(result)
            }
            if (!errorCheck) {
                errorCheck = checkMaxHHundredThousand(result)
            }
            if (!errorCheck) {
                errorCheck = checkThousand(result)
            }
            return errorCheck
        }

        fun checkVacant(result: String): Boolean {
            require((result.replace(" ", "")) != "") {
                throwIllegalArgumentException(errorMessageVacant)
                return true
            }
            require(result.isNotBlank()) {
                throwIllegalArgumentException(errorMessageVacant)
                return true
            }
            require(result.isNotEmpty()) {
                throwIllegalArgumentException(errorMessageVacant)
                return true
            }
            return false
        }

        fun checkStartZero(result: String): Boolean {
            require(result != "0") {
                throwIllegalArgumentException(errorMessageZeroAndMinus)
                return true
            }

            require(!zeroStartPattern.matches(result)) {
                throwIllegalArgumentException(errorMessageZeroStart)
                return true
            }
            return false
        }

        fun checkOnlyNumber(result: String): Boolean {
            require(result.toIntOrNull() is Int) {
                throwNumberFormatException(errorMessageOnlyNumber)
                return true
            }
            return false
        }

        fun checkMinusOrZero(result: String): Boolean {
            require((result.toInt()) > 0) {
                throwIllegalArgumentException(errorMessageZeroAndMinus)
                return true
            }
            return false
        }

        fun checkMaxHHundredThousand(result: String): Boolean {
            require(result.toInt() in 1000..100000) {
                throwIllegalArgumentException(errorMessageMaxHundredThousand)
                return true
            }
            return false
        }

        fun checkThousand(result: String): Boolean {
            require((result.toInt() % 1000) == 0) {
                throwIllegalArgumentException(errorMessageThousand)
                return true
            }
            return false

        }


        fun throwIllegalArgumentException(errorMessage: String) {
            return try {
                throw IllegalArgumentException()
            } catch (e: IllegalArgumentException) {
                println(errorMessage)
            }
        }

        fun throwNumberFormatException(errorMessage: String) {
            return try {
                throw NumberFormatException()
            } catch (e: NumberFormatException) {
                println(errorMessage)
            }
        }

        fun throwIllegalStateException(errorMessage: String) {
            return try {
                throw IllegalStateException()
            } catch (e: IllegalStateException) {
                println(errorMessage)
            }
        }
        //상태값 예외처리


    }
}
