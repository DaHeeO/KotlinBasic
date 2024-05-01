package org.example.operator

class ArithmeticOperator {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val a = 1 + 1 // 2
			val b = 4 + 8 // 12
			val c = 4 * 2 // 8
			val d = 4 / 2 // 2
			val e = 3 / 2 // 1
			val f = 3.0 / 2 // 1.5
			val g = 1.0 / 3 // 0.333333333
			val h = 5 % 2 // 1

			println("a : $a")
			println("b : $b")
			println("c : $c")
			println("d : $d")
			println("e : $e")
			println("f : $f")
			println("g : $g")
			println("h : $h")
		}
	}
}
