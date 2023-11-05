package lotto.domain

sealed class Place(val correct: Int, val price: Int, val bonus: Boolean) {
    data object First : Place(6, 2000000000, false)

    data object Second : Place(5, 30000000, true)

    data object Third : Place(5, 1500000, false)

    data object Fourth : Place(4, 50000, false)

    data object Fifth : Place(3, 5000, false)

    data object NonPlace : Place(2, 0, false)

    companion object {
        fun decidePlace(correct: Int, bonus: Boolean): Place {
            return when {
                correct == First.correct && bonus == First.bonus -> First
                correct == Second.correct && bonus == Second.bonus -> Second
                correct == Third.correct && bonus == Third.bonus -> Third
                correct == Fourth.correct && bonus == Fourth.bonus -> Fourth
                correct == Fifth.correct && bonus == Fifth.bonus -> Fifth
                else -> NonPlace
            }
        }
    }
}