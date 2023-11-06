package lotto

enum class Position(val winningPrize: Int) {
    First(2000000000),
    Second(30000000),
    Third(1500000),
    Fourth(50000),
    Fifth(5000),
    NoLuck(0),
}
