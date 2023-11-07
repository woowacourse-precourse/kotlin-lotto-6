package lotto

enum class priceHowManyMatch(private val price:Int) {
    일치3개(5000),
    일치4개(50000),
    일치5개(1500000),
    일치5개보너스(30000000),
    일치6개(2000000000);

    fun priceReturn() = price
}