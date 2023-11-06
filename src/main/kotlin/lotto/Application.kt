package lotto

fun pickLottoNumbers(): Lotto {
    val numbers = pickUniqueNumbersInRange(
        LottoConstraints.NUMBER_START, LottoConstraints.NUMBER_END, LottoConstraints.NUMBER_COUNT
    )
    return Lotto(numbers)
}

fun main() {
    TODO("프로그램 구현")
}
