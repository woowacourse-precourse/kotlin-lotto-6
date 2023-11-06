package lotto.model

sealed interface PlayLottoState {

    enum class State : PlayLottoState {
        IDLE,
        PURCHASE_AMOUNT,
        WINNING_NUMBERS,
        BONUS_NUMBER,
        MATCHING,
        END
    }

    data class LottoData(
        var winningNumbers: List<Int> = emptyList(),
        var purchaseAmount : Double = 0.0,
        var bonusNumber : Int = 0,
        var currentState : State = State.IDLE
    ) : PlayLottoState {

        var lotteries: List<List<Int>> = emptyList()
            set(value) {
                value.forEach(::println)
                field = value
            }
    }
}
