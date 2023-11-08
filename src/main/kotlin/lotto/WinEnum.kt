package lotto

enum class WinEnum(val win: Int, val winMoney: String, var counts: Int) {
    FIFTH(5000, "5,000원", 0),
    FOURTH(50000, "50,000원", 0),
    THIRD(1500000, "1,500,000원", 0),
    SECOND(30000000, "30,000,000원", 0),
    FIRST(2000000000, "2,000,000,000원", 0)
}