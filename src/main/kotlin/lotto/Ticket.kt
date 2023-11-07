package lotto

import camp.nextstep.edu.missionutils.Console

class Ticket() {
    val numberOfLotto: Int
    private val price: String

    init {
        price = Console.readLine()
        validateInt(price)
        validatePrice(price)
        numberOfLotto = price.toInt() / TICKET_PRICE
    }


    private fun validateInt(price: String) {
        require(price.toIntOrNull() != null && price.toInt() > 0) { ERROR_MESSAGE.format(NOT_NUMBER.format(price)) }
    }

    private fun validatePrice(price: String) {
        require(price.toInt() % TICKET_PRICE == 0) { ERROR_MESSAGE.format(REMAIN_CHARGE) }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR] %s"
        const val TICKET_PRICE = 1000
        const val NOT_NUMBER = "입력 받은 %s 는 양의 정수가 아닙니다."
        const val REMAIN_CHARGE = "${TICKET_PRICE}보다 작은 단위의 잔돈이 입력되었습니다."
    }

}