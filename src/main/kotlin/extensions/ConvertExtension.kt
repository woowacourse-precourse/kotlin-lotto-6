package extensions

fun String.withCommaToList(): List<Int> = split(",").map { it.toInt() }