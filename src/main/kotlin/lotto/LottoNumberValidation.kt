package lotto

fun hasSixNumbers(numbers: List<Int>): Boolean {
    return numbers.size == LottoConstraints.NUMBER_COUNT
}

fun isInValidRange(numbers: List<Int>): Boolean {
    return numbers.all { (LottoConstraints.NUMBER_START <= it) and (it <= LottoConstraints.NUMBER_END) }
}

fun isUnique(numbers: List<Int>): Boolean {
    val uniqueNumbers: HashSet<Int> = hashSetOf()
    return numbers.all { uniqueNumbers.add(it) }
}

