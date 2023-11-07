package lotto.util

class Task {
    var inputState: State = State.INPUT_PURCHASEA_MOUNT

    enum class State {
        INPUT_PURCHASEA_MOUNT, INPUT_WINNING_AND_BONUS_NUMBERS, DONE
    }
}