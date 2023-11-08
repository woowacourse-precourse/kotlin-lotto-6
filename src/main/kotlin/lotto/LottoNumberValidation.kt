package lotto

fun hasSixNumbers(numbers: List<Int>): Boolean {
    return numbers.size == LottoConstraints.NUMBER_COUNT
}

fun areAllNumbersInValidRange(numbers: List<Int>): Boolean {
    return numbers.all { isNumberInValidRange(it) }
}

fun isNumberInValidRange(number: Int): Boolean {
    return (LottoConstraints.NUMBER_START <= number) and (number <= LottoConstraints.NUMBER_END)
}

fun isUnique(numbers: List<Int>): Boolean {
    val uniqueNumbers: HashSet<Int> = hashSetOf()
    return numbers.all { uniqueNumbers.add(it) }
}

