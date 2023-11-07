package lotto

class LottoSeller {
    var numTickets = 0
    var lottoNumbers = mutableListOf<Int>()
    var bonumNumber = 0
    fun buyTickets(inputMoney: Int) {
        if (inputMoney <= 1000) {
            throw IllegalArgumentException("구입금액은 1000원 이상이어야 합니다.")
     }
        if (inputMoney % 1000 != 0) {
            throw IllegalArgumentException("구입금액은 1000원 단위여야 합니다.")
        }

        this.numTickets = inputMoney / 1000
    }

    fun getLottoNumbers(numbers: List<Int>, bonus: Int) {

    }

    fun winningCount() {

    }

    fun getProfitRate() {

    }


}