package lotto

fun <T> List<T>.isUnique(): Boolean {
    val uniqueItems = this.toSet()
    return this.size == uniqueItems.size
}
