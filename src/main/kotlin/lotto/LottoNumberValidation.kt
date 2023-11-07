package lotto

fun hasSixNumbers(numbers: List<Int>): Boolean {
    return numbers.size == 6
}

fun isInValidRange(numbers: List<Int>): Boolean {
    return numbers.all { (1 <= it) and (it <= 45) }
}

fun isUnique(numbers: List<Int>): Boolean {
    val uniqueNumbers: HashSet<Int> = hashSetOf()
    return numbers.all { uniqueNumbers.add(it) }
}

