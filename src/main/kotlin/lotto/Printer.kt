package lotto

interface Printer {
    fun show(message: String)

    fun showBlankLine() = println()
}
