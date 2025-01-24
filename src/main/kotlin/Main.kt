package org.example

fun main() {
    var name: String? = "금민섭"
    name = null
    println(name)
}

fun Int?.isEven(): Boolean = this?.let { it % 2 == 0 } ?: false
