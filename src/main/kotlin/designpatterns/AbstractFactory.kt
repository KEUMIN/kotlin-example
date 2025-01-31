package org.example.designpatterns

fun main() {
    val bInfo = "B: 1800"
    val fInfo = "F: f600"
    val footballShoes = shoesFactory(fInfo)
    val basketballShoes = shoesFactory(bInfo)
    val footballShoesLabel: String? = footballShoes.label as? String
    val basketballShoesLabel: Long? = basketballShoes.label as? Long
    println(footballShoesLabel)
    println(basketballShoesLabel)
}

interface Shoes {
    val name: String
    val label: Any
}

data class FootballShoes(
    override val name: String,
    override val label: String,
) : Shoes

data class BasketballShoes(
    override val name: String,
    override val label: Long,
) : Shoes

fun shoesFactory(info: String): Shoes {
    val (name, label) = info.split(":")
    return when (name) {
        "B" -> BasketballShoes(name, label.trim().toLong())
        "F" -> FootballShoes(name, label.trim())
        else -> throw IllegalArgumentException("Unknown shoes info")
    }
}
