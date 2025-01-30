package org.example.designpatterns

fun main() {
    val notations = listOf("pa8", "qc3", "가8당")
    val pin1 = createPiece(notations[0])
    println(pin1)
    val pin2 = createPiece(notations[1])
    println(pin2)
    val pin3 = createPiece(notations[2])
    println(pin3)
}

fun createPiece(notation: String): ChessPiece {
    val (type, file, rank) = notation.toCharArray()
    return when (type) {
        'p' -> Pawn(rank, file)
        'q' -> Queen(rank, file)
        else -> throw RuntimeException("Unknown chess type: $type")
    }
}

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val rank: Char,
) : ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char,
) : ChessPiece
