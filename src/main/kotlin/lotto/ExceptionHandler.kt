package lotto

object ExceptionHandler {
    fun checkWinningNumber(numbers: String): Boolean {
        val numberList = numbers.split(",").map { it.trim() }

        for (numberStr in numberList) {
            val number = numberStr.toIntOrNull()

            if (number == null || number !in 1..45) {
                println("[ERROR]")
                throw IllegalArgumentException("[ERROR]")
            }
        }

        return true
    }

     fun checkNumberList(list: List<Int>): Boolean {
         if (isDuplicate(list)
             || !isOverLength(list)
             || !isInRange(list)) {
             println("[ERROR]")
             throw IllegalArgumentException("[ERROR]")
         }
         return true
     }

    private fun isDuplicate(list: List<Int>): Boolean {
        val distinctList = list.distinct()
        if (distinctList.size == 6) {
            return false
        }
        return true
    }

     private fun isOverLength(list: List<Int>): Boolean {
         if (list.size > 6) {
             return false
         }
         return true
     }

    private fun isInRange(list: List<Int>): Boolean {
        for (i in list) {
            if (i < 0 || i > 45) {
                return false
            }
        }
        return true
    }

    private fun isInRange(number: String): Boolean {
        if (number.toInt() < 0 || number.toInt() > 45) {
            return false
        }
        return true
    }

    fun checkInputMoney(money: String): Boolean {
         if (!isOnlyInt(money) || !isDivideBy1000(money.toInt())) {
             println("[ERROR]")
             throw IllegalArgumentException("[ERROR]")
         }
         return false
     }

    private fun isDivideBy1000(money: Int): Boolean {
        return (money % 1000) == 0
    }

    private fun isOnlyInt(money: String): Boolean {
        for (i in money) {
            if (i.digitToIntOrNull() == null) {
                return false
            }
        }
        return true
    }
    fun checkBonusNumber(number: String, winningNumberList: List<Int>) {
        if(!isOnlyInt(number)
            || !isInRange(number)
            || winningNumberList.contains(number.toInt())){
            println("[ERROR]")
            throw IllegalArgumentException("[ERROR]")
        }
    }
}