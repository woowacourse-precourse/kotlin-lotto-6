package lotto.util

class Task {
    var state: State = State.BUYING_AMOUNT

    fun nextState() {
        val nextProgress = state.progress + 1
        state = State.fromProgress(nextProgress) ?: state
    }

    enum class State(val progress: Int) {
        BUYING_AMOUNT(1),
        WINNING_AND_BONUS_NUMBERS(2),
        RATE_OF_RETURN(3),
        DONE(4);

        companion object {
            fun fromProgress(progress: Int): State? {
                return values().firstOrNull { it.progress == progress }
            }
        }
    }
}