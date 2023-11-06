package lotto

enum class Prize(val matchCount: Int, val prize: Int, val bonus: Boolean) {
    FIRST(6, 2000000_000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false);
}