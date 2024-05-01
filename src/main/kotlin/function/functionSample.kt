package org.example.function

fun main() {
    println(sum1(1, 2))
    println(sum2(1, 2))
    noReturnFunction("unused value")
    defaultParameter()
    namedArgument("HI,", c = "Dahee", b = "My name is")

}

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun noReturnFunction(a: String) {
    println("noReturnFunction : $a")
}

fun defaultParameter(a: String = "defualt value") {
    println(a)
}

fun namedArgument(a: String, b: String, c: String) {
    println("$a $b $c")
}