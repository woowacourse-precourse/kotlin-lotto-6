package lotto.model

enum class Place(private val correct: Int, private val bonus: Boolean) {
    FIRST(6, false), SECOND(5, true), THIRD(5, false), FOURTH(4, false), FIFTH(3, false)
}