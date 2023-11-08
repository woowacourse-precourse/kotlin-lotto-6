package lotto.extentions

fun String.stringToIntList(): List<Int> = this
    .split(",")
    .map { it
        .trim()
        .toInt()
    }.toList()