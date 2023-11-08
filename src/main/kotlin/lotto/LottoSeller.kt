package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoSeller {
    var numTickets = 0
    var winningNumbers = mutableListOf<Int>()
    var bonusNumber = 0
    var tickets = ArrayList<List<Int>>()
    fun buyTickets(inputMoney: Int) {
        if (inputMoney < 1000) {
            throw IllegalArgumentException("구입금액은 1000원 이상이어야 합니다.")
        }
        if (inputMoney % 1000 != 0) {
            throw IllegalArgumentException("구입금액은 1000원 단위여야 합니다.")
        }
        this.numTickets = inputMoney / 1000
    }

    fun createLotto() {
        println("\n${this.numTickets}개를 구매했습니다.")

        for (i in 0..numTickets - 1) {
            this.tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
            println(this.tickets[i])
        }
    }

    fun validateBonusNumber() {
        for (i in 0..this.winningNumbers.size - 1) {
            if (this.winningNumbers[i] == this.bonusNumber)
                throw IllegalArgumentException(ValidateMsg.REDUNDANT.msg)
            if (this.bonusNumber < 1 || this.bonusNumber > 45)
                throw IllegalArgumentException(ValidateMsg.NUMRANGE.msg)
        }
    }


}