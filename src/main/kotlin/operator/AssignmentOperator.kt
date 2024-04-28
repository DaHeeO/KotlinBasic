package org.example.operator

class AssignmentOperator {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var a = 5
            println(a) // 5
            a += 5
            println(a)  // 10
            a *= 2
            println(a)  // 20
            a /= 2
            println(a) // 10
            a %= 3
            println(a)  // 1
        }
    }
}