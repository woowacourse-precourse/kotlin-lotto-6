package lotto

class LottoResult {
    var win = Array<Int>(5,{0})
    var rateOfReturn:Double = 0.0

    fun print() {
        println(win.toList())
    }
}