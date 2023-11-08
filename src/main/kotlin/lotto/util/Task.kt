package lotto.util

class Task {
    var inputState: State = State.INPUT_BUYING_AMOUNT

    enum class State {
        INPUT_BUYING_AMOUNT, INPUT_WINNING_AND_BONUS_NUMBERS, DONE
    }
}