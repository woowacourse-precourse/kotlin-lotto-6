package extensions

private const val LOTTO_PRICE = 1000

fun String.withCommaToList(): List<Int> = split(",").map { it.toInt() }
fun Int.toPurchaseLottoCount() = this / LOTTO_PRICE
