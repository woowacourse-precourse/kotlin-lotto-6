package lotto

enum class ErrorMessage(private val message: String) {
    INVALID_NUMBER("입력하신 값은 자연수가 아닙니다."),
    REMAIN_CHARGE("${Ticket.TICKET_PRICE}보다 작은 단위의 잔돈이 입력되었습니다."),
    INVALID_LOTTO_LENGTH("당첨번호의 숫자가 6자리가 아닙니다."),
    INVALID_LOTTO_UNIQUE("당첨번호의 숫자에 중복이 존재합니다."),
    INVALID_LOTTO_RANGE("번호가 1부터 45까지의 숫자가 아닙니다."),
    DUPLICATED_NUMBER("중복된 입력입니다.");

    fun getMessage(): String = "[ERROR] $message"
}


