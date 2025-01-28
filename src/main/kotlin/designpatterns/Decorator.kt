package org.example.designpatterns

fun main() {
    val basic = BasicPrinter()
    val logger = LoggerPrinter(basic)
    val validator = ValidationPrinter(logger)

    validator.print("개코원숭이")
    validator.print("긴꼬리개코원숭이")
}

interface Printer {
    fun print(input: String)
}

class BasicPrinter : Printer {
    override fun print(input: String) {
        println(input)
    }
}

class LoggerPrinter(
    val printer: Printer,
) : Printer by printer {
    override fun print(input: String) {
        println("Print Start!")
        printer.print(input)
        println("Print End!")
    }
}

class ValidationPrinter(
    val printer: Printer,
) : Printer by printer {
    override fun print(input: String) {
        if (input.length > 5) throw RuntimeException("Too long input!")
        printer.print(input)
    }
}
