package lotto

class CheckSystem {
    companion object {
        val zeroStartPattern = Regex("^0{1,}[0-9]{1,}")
        val numberAndCommaPattern = Regex("^\\d+(,\\d+)*\$")
        val startCommaPattern = Regex("^,(\\d+)")
        val lastCommaPattern = Regex(".*,\$")
        val onlyCommaPattern = Regex("[,]{1,}")
        val onlyNumberPattern = Regex("\\d")
        val repeatCommaPattern = Regex("^\\d+(,\\d+)+?(,\\d*)*\$")

        private const val errorMessageVacant = "[ERROR] 비어있거나 입력하지 않으셨습니다"
        private const val errorMessageZeroAndMinus = "[ERROR] 0 또는 음수를 입력하셨습니다"
        private const val errorMessageOnlyNumber = "[ERROR] 숫자만 입력할 수 있습니다"
        private const val errorMessageZeroStart = "[ERROR] 0으로 시작하는 숫자를 입력하셨습니다"
        private const val errorMessageOneToFortyfive = "[ERROR] 숫자범위를 벗어났습니다. (범위 : 1 ~ 45)"
        private const val errorMessageThousand = "[ERROR] 1000 단위 숫자가 아닙니다"
        private const val errorMessageMaxHundredThousand =
            "[ERROR] 숫자범위를 벗어났습니다. (범위 : 1000 ~ 100000)"
        private const val errorMessageRepeatNumber = "[ERROR] 중복된 숫자를 입력하셨습니다"
        private const val errorMessageNumberNotSix = "[ERROR] 번호가 6개가 아닙니다"
        private const val errorMessageNumberAndComma = "[ERROR] 숫자와 쉼표만 입력할 수 있습니다"
        private const val errorMessageLastComma = "[ERROR] 마지막 부분이 쉼표로 끝나면 안됩니다"
        private const val errorMessageStartComma = "[ERROR] 시작 부분이 쉼표로 시작되면 안됩니다"
        private const val errorMessageOnlyComma = "[ERROR] 쉼표만 사용되면 안됩니다"
        private const val errorMessageRepeatComma = "[ERROR] 쉼표가 연속입력되면 안됩니다"
        private const val errorMessageNotComma = "[ERROR] 쉼표가 입력되지 않았습니다"

        var errorCheck = false
        var inputBounsBall = 0
        var inputChosenBall6 = listOf<String>()
        val ballOneToFortyfive = (1..45).toList()


        private fun checkVacant(result: String): Boolean {
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

        fun inputCheck(result: String, caseNumber: Int): Boolean {
            errorCheck = CheckSystem.checkVacant(result)
            if (!errorCheck) {
                errorCheck = CheckSystem.checkStartZero(result)
            }
            if (!errorCheck && (caseNumber == 1 || caseNumber == 3)) {
                errorCheck = CheckSystem.checkOnlyNumber(result)
            }
            if (!errorCheck && (caseNumber == 1 || caseNumber == 3)) {
                errorCheck = CheckSystem.checkMinusOrZero13(result)
            } else if (!errorCheck && caseNumber == 2) {
                errorCheck = CheckSystem.checkMinusOrZero2(result)
            }
            if (!errorCheck && caseNumber == 2) {
                errorCheck = CheckSystem.checkOnlyNumberAndComma(result)
            }
            if (!errorCheck && caseNumber == 1) {
                errorCheck = CheckSystem.checkThousandToHundredThousand(result)
            } else if (!errorCheck && (caseNumber == 2)) {
                errorCheck = CheckSystem.checkOneToFortyFive2(result)
            } else if (!errorCheck && caseNumber == 3) {
                errorCheck = CheckSystem.checkOneToFortyFive3(result)
            }
            if (!errorCheck && caseNumber == 2) {
                errorCheck = CheckSystem.checkRepeatNumber(result)
            }

            if (!errorCheck && caseNumber == 1) {
                errorCheck = CheckSystem.checkThousand(result)
            }
            return errorCheck
        }

        private fun checkStartZero(result: String): Boolean {
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

        private fun checkOnlyNumber(result: String): Boolean {
            require(result.toIntOrNull() is Int) {
                throwNumberFormatException(errorMessageOnlyNumber)
                return true
            }
            return false
        }

        private fun checkOnlyNumberAndComma(result: String): Boolean {
            println("입력값 : ${result}")
            require(numberAndCommaPattern.matches(result)) {
                if (onlyCommaPattern.matches(result)) {
                    throwIllegalArgumentException(errorMessageOnlyComma)
                    return true
                }
                if (startCommaPattern.matches(result)) {
                    throwIllegalArgumentException(errorMessageStartComma)
                    return true

                }
                if (lastCommaPattern.matches(result)) {
                    throwIllegalArgumentException(errorMessageLastComma)
                    return true
                }
                if (onlyNumberPattern.matches(result)) {
                    throwIllegalArgumentException(errorMessageNotComma)
                    return true
                }
                if (repeatCommaPattern.matches(result)) {
                    throwIllegalArgumentException(errorMessageRepeatComma)
                    return true
                }
                throwIllegalArgumentException(errorMessageNumberAndComma)
                return true
            }
            return false
        }

        private fun checkMinusOrZero13(result: String): Boolean {
            require((result.toInt()) > 0) {
                throwIllegalArgumentException(errorMessageZeroAndMinus)
                return true
            }
            return false
        }

        private fun checkMinusOrZero2(result: String): Boolean {

            if (result.toIntOrNull() is Int && result.toInt() <= 0) {
                throwIllegalArgumentException(errorMessageZeroAndMinus)
                return true
            }
            return false
        }

        private fun checkThousandToHundredThousand(result: String): Boolean {
            require(result.toInt() in 1000..100000) {
                throwIllegalArgumentException(errorMessageMaxHundredThousand)
                return true
            }
            return false
        }

        private fun checkThousand(result: String): Boolean {
            require((result.toInt() % 1000) == 0) {
                throwIllegalArgumentException(errorMessageThousand)
                return true
            }
            return false
        }

        private fun checkOneToFortyFive2(result: String): Boolean {
            inputChosenBall6 = result.split(",").toList()
            println("입력리스트 : ${inputChosenBall6}")
            require(inputChosenBall6.size == 6) {
                throwNumberFormatException(errorMessageNumberNotSix)
                return true
            }
            for (inputball in inputChosenBall6) {
                require(ballOneToFortyfive.contains(inputball.toInt())) {
                    throwIllegalArgumentException(errorMessageOneToFortyfive)
                    return true
                }
            }
            return false
        }

        private fun checkOneToFortyFive3(result: String): Boolean {
            CheckSystem.inputBounsBall = result.toInt()
            require(inputBounsBall in 1..45) {
                CheckSystem.throwIllegalArgumentException(errorMessageOneToFortyfive)
                return true
            }
            return false
        }

        private fun checkRepeatNumber(result: String): Boolean {
            inputChosenBall6 = result.split(",").toList().distinct()
            println("입력리스트 : ${inputChosenBall6}")
            require(inputChosenBall6.size == 6) {
                CheckSystem.throwNumberFormatException(errorMessageRepeatNumber)
                return true
            }
            return false
        }

        private fun throwIllegalArgumentException(errorMessage: String) {
            return try {
                throw IllegalArgumentException()
            } catch (e: IllegalArgumentException) {
                println(errorMessage)
            }
        }

        private fun throwNumberFormatException(errorMessage: String) {
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
    }
}