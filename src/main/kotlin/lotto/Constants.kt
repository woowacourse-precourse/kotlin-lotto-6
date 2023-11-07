package lotto

enum class WinningAmounts(val amounts: Int){
    threeMatch(5000),
    fourMatch(50000),
    fiveMatch(1500000),
    fiveAndBonus(30000000),
    sixMatch(2000000000)
}

enum class UnitAmount(val price: Int){
    unit(1000)
}