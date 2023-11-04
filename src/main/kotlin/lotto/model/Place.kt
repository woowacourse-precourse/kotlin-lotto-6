package lotto.model

sealed class Place(val correct: Int, val price: Int, val bonus: Boolean) {
    data object First : Place(6, 2000000000, false)

    data object Second : Place(5, 30000000, true)

    data object Third : Place(5, 1500000, false)

    data object Fourth : Place(4, 50000, false)

    data object Fifth : Place(3, 5000, false)

    data object NonPlace : Place(2, 0, false)

}