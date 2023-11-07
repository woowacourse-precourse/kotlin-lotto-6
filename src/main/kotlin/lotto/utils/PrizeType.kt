package lotto.utils

enum class PrizeType(val price: Int) {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NON(0);

    companion object {
        fun getPrice(name: String?): Int {
            return values().find {
                it.name.uppercase() == name?.uppercase()
            }?.price ?: 0
        }
    }
}