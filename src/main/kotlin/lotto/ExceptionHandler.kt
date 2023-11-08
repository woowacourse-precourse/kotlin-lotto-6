package lotto

object ExceptionHandler {
     fun checkLotto(lotto: Lotto): Boolean {
         if (isDuplicate(lotto.numberList)
             || isOverLength(lotto.numberList)
             || isInRange(lotto.numberList)) {
             throw IllegalArgumentException("checkLotto : 잘못된 입력입니다.")
         }
        return true
    }

     fun checkNumberList(list: List<Int>): Boolean {
         if (isDuplicate(list)
             || isOverLength(list)
             || isInRange(list)) {
             throw IllegalArgumentException("checkLotto : 잘못된 입력입니다.")
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

     fun checkInputMoney(money: String): Boolean {
         if (!isOnlyInt(money) || !isDivideBy1000(money.toInt())) {
             throw IllegalArgumentException("checkInputMoney 잘못된 입력입니다.")
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