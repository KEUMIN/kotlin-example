package org.example.designpatterns

typealias CalculateStrategy = (Int, Int) -> Int

var plusStrategy: CalculateStrategy = { a, b -> a + b }
var minusStrategy: CalculateStrategy = { a, b -> a - b }
var timesStrategy: CalculateStrategy = { a, b -> a * b }
var divideStrategy: CalculateStrategy = { a, b -> a / b }

class Calculator(
    private var strategy: CalculateStrategy,
) {
    fun setStrategy(calculator: CalculateStrategy) {
        this.strategy = calculator
    }

    fun calculate(
        a: Int,
        b: Int,
    ): Int = strategy(a, b)
}

fun main() {
    val calculator = Calculator(plusStrategy)
    println("1 더하기 2는 ${calculator.calculate(1,2)}")
    calculator.setStrategy(timesStrategy)
    println("2 곱하기 3은 ${calculator.calculate(2,3)}")
}
